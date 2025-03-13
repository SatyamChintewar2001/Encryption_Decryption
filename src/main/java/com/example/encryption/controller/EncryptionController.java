package com.example.encryption.controller;

import com.example.encryption.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public String encryptFirstName(@RequestParam String firstName) {
        try {
            return encryptionService.encrypt(firstName);
        } catch (Exception e) {
            return "Encryption failed: " + e.getMessage();
        }
    }

    @PostMapping("/decrypt")
    public String decryptFirstName(@RequestParam String encryptedData, @RequestParam String firstName) {
        try {
            return encryptionService.decrypt(encryptedData, firstName);
        } catch (Exception e) {
            return "Decryption failed: " + e.getMessage();
        }
    }
}