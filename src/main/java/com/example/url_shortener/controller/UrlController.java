package com.example.url_shortener.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.url_shortener.model.UrlMapping;
import com.example.url_shortener.service.UrlService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") 
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("longUrl");
        String shortCode = urlService.shortenUrl(longUrl);
        String shortUrl = "http://localhost:8081/api/v1/" + shortCode;
        return ResponseEntity.ok(Map.of("shortUrl", shortUrl));
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortCode) {
        String longUrl = urlService.getLongUrlAndIncrementClick(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }

    @GetMapping("/analytics/{shortCode}")
    public ResponseEntity<UrlMapping> getAnalytics(@PathVariable String shortCode) {
        UrlMapping mapping = urlService.getAnalytics(shortCode);
        return ResponseEntity.ok(mapping);
    }
}