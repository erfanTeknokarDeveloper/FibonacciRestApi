package com.example.finalfibunachirestapi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Fibonacci implements Serializable {

    private Long id;

    private Integer resultNumber;

    private Integer requestNumber;

}
