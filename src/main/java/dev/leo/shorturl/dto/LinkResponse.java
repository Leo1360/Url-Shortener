package dev.leo.shorturl.dto;

import java.time.LocalDateTime;

import dev.leo.shorturl.model.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponse {
    private String longVersion;
    private String shortVersion;
    private String qrCodeUrl;
    private LocalDateTime validUtil;
    private boolean expirable;

    public Link toLink(){
        return new Link(longVersion, shortVersion, qrCodeUrl, expirable, validUtil);
    }

    public static LinkResponse of(Link link){
        return new LinkResponse(
            link.getLongVersion(),
            link.getShortVersion(),
            link.getQrCodeUrl(),
            link.getValidUntil(),
            link.isExpirable()
            );
    }
}
