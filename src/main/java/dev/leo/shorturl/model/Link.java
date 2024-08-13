package dev.leo.shorturl.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "links")
public class Link {
    @Id
    @Column(name = "lnk-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String longVersion;

    private String shortVersion;

    private String qrCodeUrl;
    
    private boolean expirable;

    private LocalDateTime validUntil;

    public Link(String longVersion, String shotVersion, String qrCodeUrl, boolean expirable, LocalDateTime validUntil) {
        this.longVersion = longVersion;
        this.shortVersion = shotVersion;
        this.qrCodeUrl = qrCodeUrl;
        this.expirable = expirable;
        this.validUntil = validUntil;
    }

    
}
