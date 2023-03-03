package com.example.pafassessment.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pafassessment.model.Userdata;
import com.example.pafassessment.repository.AccountsRepository;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping
public class FundsTransferRestController {
    
    @Autowired
    AccountsRepository repo;

    @GetMapping(path = "/names")
    public ResponseEntity<String> getAllNames() {

        List<Userdata> names = repo.getAllNames();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (Userdata r : names) {
            arrBuilder.add(r.toJSON());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                        .add("names", arrBuilder)
                        .build().toString());
    }
    

    // @PostMapping(path="/transfer", consumes =MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // public ResponseEntity<String> fundTransfer() {


    //     return null;
    // }
}
