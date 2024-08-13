package dev.leo.shorturl.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.leo.shorturl.model.Link;
import dev.leo.shorturl.services.LinkService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SiteController {
    private final LinkService linkService;

    @GetMapping(path = "/{shortUrl}")
    public String redir(@PathVariable String shortUrl){
        String longUrl = linkService.getByShortVersion(shortUrl)
                .filter(l -> l.getValidUntil().isAfter(LocalDateTime.now()) || !l.isExpirable())
                .map(Link::getLongVersion)
                .orElse("/notFound");
        return "redirect:" + longUrl;
    }
}
