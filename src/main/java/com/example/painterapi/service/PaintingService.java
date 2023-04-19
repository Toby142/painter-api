package com.example.painterapi.service;

import com.example.painterapi.models.Painting;
import com.example.painterapi.repository.PaintingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaintingService {

    @Autowired
    PaintingRepository repository;

    public Painting getPaintingById(int id) {
        Optional<Painting> painting = repository.findById(id);
        return painting.orElse(null);
    }

    public List<Painting> getAllPaintings(){
        List<Painting> paintings = new ArrayList<Painting>();
        repository.findAll().forEach(paintings::add);
        return paintings;
    }

    public void saveOrUpdate(Painting painting) {
        repository.save(painting);
    }

    public void deletePaintingById(int id) {
        repository.deleteById(id);
    }

}
