package com.example.url_shortener.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "url_mapping")
@Data
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "long_url", columnDefinition = "TEXT", nullable = false)
    private String longUrl;

    @Column(name = "short_code", unique = true)
    private String shortCode;

    @Column(name = "click_count")
    private int clickCount = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}