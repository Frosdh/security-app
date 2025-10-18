package com.example.demo.controller;

import com.example.demo.service.AesEncryptionService;
import com.example.demo.service.RsaEncryptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crypto")
public class Cryptocontroller {

    private final AesEncryptionService aesService;
    private final RsaEncryptionService rsaService;

    public Cryptocontroller() throws Exception {
        this.aesService = new AesEncryptionService();
        this.rsaService = new RsaEncryptionService();
    }

    @PostMapping("/aes/encrypt")
    public String encryptAes(@RequestBody String input) throws Exception {
        // Eliminar comillas extras si el JSON lo envía como string
        input = input.replaceAll("^\"|\"$", "");
        return aesService.encrypt(input);
    }

    @PostMapping("/aes/decrypt")
    public String decryptAes(@RequestBody String input) throws Exception {
        input = input.replaceAll("^\"|\"$", "");
        return aesService.decrypt(input);
    }

    @PostMapping("/rsa/encrypt")
    public String encryptRsa(@RequestBody String input) throws Exception {
        input = input.replaceAll("^\"|\"$", "");
        return rsaService.encrypt(input);
    }

    @PostMapping("/rsa/decrypt")
    public String decryptRsa(@RequestBody String input) throws Exception {
        input = input.replaceAll("^\"|\"$", "");
        return rsaService.decrypt(input);
    }
}
