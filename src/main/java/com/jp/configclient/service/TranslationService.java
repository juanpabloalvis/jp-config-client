package com.jp.configclient.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
@Log4j2
public class TranslationService {
    Map<String, String> words = new HashMap<>();

    @PostConstruct
    public void init() {
        words.put("Hello", "Hola");
        words.put("Afford", "Asumir");
        words.put("Run Into", "Encontrarse");
    }

    @Cacheable("translations")
    public Optional<String> getTranslation(String key) {
        log.info("The word[{}] ot found in cache, searching inside method", key);
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
        }
        for (String word : words.keySet()) {
            if (word.equals(key)) {
                return Optional.of(words.get(key));
            }
        }
        return Optional.empty();
    }

    @CacheEvict("translations")
    public void getDeleteTranslation(String msg) {
        // Evict cache
    }
}
