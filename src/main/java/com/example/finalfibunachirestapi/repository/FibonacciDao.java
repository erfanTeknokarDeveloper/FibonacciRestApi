package com.example.finalfibunachirestapi.repository;


import com.example.finalfibunachirestapi.model.Fibonacci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FibonacciDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "fibonacci";


    public boolean save(Fibonacci fibonacci) {

        try {
            redisTemplate.opsForHash().put(KEY, fibonacci.getId().toString(), fibonacci);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Fibonacci> findAll() {

        try {
            return (List<Fibonacci>) redisTemplate.opsForHash().values(KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Fibonacci findById(Long id) {
        try {
            return (Fibonacci) redisTemplate.opsForHash().get(KEY, id.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
