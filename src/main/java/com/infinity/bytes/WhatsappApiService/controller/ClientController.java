package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.service.ClientServiceImpl;
import com.infinity.bytes.WhatsappApiService.service.IMainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private IMainService objClientService;

    public ClientController(ClientServiceImpl objClientService) {
        this.objClientService = objClientService;
    }


    @GetMapping
    public ResponseEntity<?> getAllClients(){
        return new ResponseEntity<>(objClientService.getAllData(),
                HttpStatus.OK);
    }
}
