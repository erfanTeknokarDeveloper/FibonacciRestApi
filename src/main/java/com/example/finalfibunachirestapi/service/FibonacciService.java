package com.example.finalfibunachirestapi.service;

import com.example.finalfibunachirestapi.model.Fibonacci;
import com.example.finalfibunachirestapi.repository.FibonacciDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {


    @Autowired
    private FibonacciDao fibonacciDao;

    Long id = 1L;

    public Integer calculator(Integer input) {

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.setId(id);
        fibonacci.setRequestNumber(input);

        id++;

        int sum = 0;

        int a = 1;

        int b = 1;

        List<Integer> fi = new ArrayList<>();


        if (fibonacciDao.findById(fibonacci.getId()).getRequestNumber() == input && fibonacciDao.findById(fibonacci.getId()) != null) {
            return fibonacciDao.findById(fibonacci.getId()).getResultNumber();
        }

        fi.add(a);
        if (fibonacci.getRequestNumber() == 1) {
            return 1;
        }

        fi.add(b);
        if (fibonacci.getRequestNumber() == 2) {
            return 1;
        }


        for (int i = 0; i < fibonacci.getRequestNumber() - 2; i++) {
            sum = a + b;
            a = b;
            b = sum;
            fi.add(sum);
        }

        fibonacci.setResultNumber(sum);
        fibonacciDao.save(fibonacci);


        return sum;
    }

    public List<Fibonacci> findAll() {

        List<Fibonacci> all = fibonacciDao.findAll();
        return all;
    }

}
