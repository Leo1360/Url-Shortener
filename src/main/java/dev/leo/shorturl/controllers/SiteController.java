package dev.leo.shorturl.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.leo.shorturl.dto.LinkRequest;
import dev.leo.shorturl.model.Link;
import dev.leo.shorturl.services.LinkService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SiteController {
    private final LinkService linkService;

    @GetMapping(path = "/l/{shortUrl}")
    public String redir(@PathVariable String shortUrl){
        String longUrl = linkService.getByShortVersion(shortUrl)
                .filter(l -> l.getValidUntil().isAfter(LocalDateTime.now()) || !l.isExpirable())
                .map(Link::getLongVersion)
                .orElse("/notFound");
        return "redirect:" + longUrl;
    }

    @PostMapping(path = "/generate")
    public String generate(@ModelAttribute LinkRequest linkRequest, Model model){
        Link link = linkService.shorteningUrl(linkRequest.getLongLink(), linkRequest.getTtd());
        model.addAttribute("shortlink", link.getShortVersion());
        return "shortedlink";
    }

}
