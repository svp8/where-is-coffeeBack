package com.vlad.wicBackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafesController {
    @GetMapping("/cafe")
    public String getCafes(){
        return "cafe1 cafe2";
    }
}
