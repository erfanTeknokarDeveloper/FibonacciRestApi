package com.example.finalfibunachirestapi.controller;

import com.example.finalfibunachirestapi.model.Fibonacci;
import com.example.finalfibunachirestapi.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/{number}")
    public ResponseEntity<Integer> calculateFibonacci(@PathVariable Integer number) {
       return ResponseEntity.ok(fibonacciService.calculator(number));
    }


    @GetMapping
    public ResponseEntity<List<Fibonacci>> findAll() {
       return ResponseEntity.ok(fibonacciService.findAll());
    }
}
