package dev.leo.shorturl.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import dev.leo.shorturl.model.Link;
import dev.leo.shorturl.repo.LinkRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepo repo;

    public String getRandomUrl(){
        return RandomStringUtils.randomAlphanumeric(5,10);
    }

    public Link shorteningUrl(String longUrl, int ttd){
        String shortUrl = getRandomUrl();
        while (repo.existsByShortVersion(shortUrl)) {
            shortUrl = getRandomUrl();
        }
        
        Link link = new Link(
            longUrl,
            shortUrl,
            "qrcode404", //TODO - QRCODE - ADD qrcode path here
            (ttd > 0),
            LocalDateTime.now().plusMinutes(ttd)
        );
        repo.save(link);
        return link;

    }

    public Optional<Link> getByShortVersion(String shortUrl){
        return repo.findByShortVersion(shortUrl);
    }
}
