package com.example.painterapi.repository;

import com.example.painterapi.models.Painter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PainterRepository extends CrudRepository<Painter, Integer> {
}
