package com.misviajes.lodging.controller;


import com.misviajes.lodging.dto.LodgingRequest;
import com.misviajes.lodging.dto.LodgingResponse;
import com.misviajes.lodging.sevice.LodgingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("/lodging")
public class LodgingController {

    @Autowired
    private LodgingService lodgingService;

    @GetMapping
    private ResponseEntity<List<LodgingResponse>> getAll() {
        var response = lodgingService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<LodgingResponse> getById(@PathVariable("id") Long id) {
        var response = lodgingService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<LodgingResponse> create(@RequestBody LodgingRequest request) {
        var response = lodgingService.create(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<LodgingResponse> getById(@RequestBody LodgingRequest request, @PathVariable("id") Long id) {
        var response = lodgingService.update(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        lodgingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
