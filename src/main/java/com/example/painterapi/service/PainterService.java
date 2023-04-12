package com.example.painterapi.service;

import com.example.painterapi.models.Painter;
import com.example.painterapi.repository.PainterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PainterService {

    @Autowired
    PainterRepository repository;

    public Painter getPainterById(int id) {
        Optional<Painter> painter = repository.findById(id);
        return painter.orElse(null);
    }

    public List<Painter> getAllPainters(){
        List<Painter> painters = new ArrayList<Painter>();
        repository.findAll().forEach(painters::add);
        return painters;
    }

    public void saveOrUpdate(Painter painter) {
        repository.save(painter);
    }

    public void deletePainterById(int id) {
        repository.deleteById(id);
    }
}
