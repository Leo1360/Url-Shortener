package dev.leo.shorturl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequest {
    private String longLink;
    private int ttd;
}
