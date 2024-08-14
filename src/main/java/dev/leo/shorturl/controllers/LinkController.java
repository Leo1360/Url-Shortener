package dev.leo.shorturl.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.leo.shorturl.dto.LinkRequest;
import dev.leo.shorturl.dto.LinkResponse;
import dev.leo.shorturl.model.Link;
import dev.leo.shorturl.services.LinkService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class LinkController {
    private final LinkService linkService;

    @PostMapping(path = "/short")
    public ResponseEntity<LinkResponse> shortUrl(@RequestBody LinkRequest linkRequest){
        Link shortLink = linkService.getByShortVersion(linkRequest.getLongLink())
            .orElse(linkService.shorteningUrl(linkRequest.getLongLink(),linkRequest.getTtd()));
        return new ResponseEntity<LinkResponse>(LinkResponse.of(shortLink),HttpStatus.OK);
    }
    
    @GetMapping(path = "/get/{shortLink}")
    public ResponseEntity<LinkResponse> getLongLink(@PathVariable String shortLink){
        Link link = linkService.getByShortVersion(shortLink)
                .filter(l -> l.getValidUntil().isAfter(LocalDateTime.now()) || !l.isExpirable())
                .orElse(new Link("notFound","","",false,null));
        return new ResponseEntity<LinkResponse>(LinkResponse.of(link), HttpStatus.OK);
    }

}
