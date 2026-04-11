package ru.mtuci.coursemanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class ProxyController {

    private static final List<String> ALLOWED_HOSTS = List.of(
            "api.example.com",
            "data.example.com"
    );

    @GetMapping("/api/proxy")
    public ResponseEntity<String> proxy(@RequestParam("targetUrl") String targetUrl) {
        try {
            URI uri = URI.create(targetUrl);
            String host = uri.getHost();
            if (host == null || !ALLOWED_HOSTS.contains(host)) {
                return ResponseEntity.badRequest().body("Host not allowed");
            }
            RestTemplate rt = new RestTemplate();
            return ResponseEntity.ok(rt.getForObject(targetUrl, String.class));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid URL");
        }
    }
}