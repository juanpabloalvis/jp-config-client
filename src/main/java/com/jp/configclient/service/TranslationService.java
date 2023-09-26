package com.jp.configclient.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class TranslationService {
    Map<String, String> words = new HashMap<>();

    @PostConstruct
    public void init() {
        words.put("Hello", "Hola");
        words.put("Afford", "Asumir");
        words.put("Run Into", "Encontrarse");
    }

    public Optional<String> getTranslation(String key) {
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
        }
        for (String word : words.keySet()) {
            if (word.equals(key)) {
                return Optional.of(words.get(key));
            }
        }
        return Optional.empty();
    }
}
