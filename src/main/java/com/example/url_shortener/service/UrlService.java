package com.example.url_shortener.service;

import com.example.url_shortener.model.UrlMapping;
import com.example.url_shortener.repository.UrlRepository;
import com.example.url_shortener.util.Base62;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Transactional
    public String shortenUrl(String longUrl) {
        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(longUrl);
        mapping = urlRepository.save(mapping);
        
        String shortCode = Base62.encode(mapping.getId());
        mapping.setShortCode(shortCode);
        
        urlRepository.save(mapping);
        return shortCode;
    }

    @Transactional
    public String getLongUrlAndIncrementClick(String shortCode) {
        UrlMapping mapping = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL code not found"));
        
        mapping.setClickCount(mapping.getClickCount() + 1);
        urlRepository.save(mapping);
        return mapping.getLongUrl();
    }

    public UrlMapping getAnalytics(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL code not found"));
    }
}