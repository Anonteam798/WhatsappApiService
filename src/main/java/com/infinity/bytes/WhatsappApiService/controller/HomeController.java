package com.infinity.bytes.WhatsappApiService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/home")
public class HomeController {

    @GetMapping
    public String showMessage(){
        return "Hola mundo";
    }


}
