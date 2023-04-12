package com.example.painterapi;

import com.example.painterapi.models.Painter;
import com.example.painterapi.service.PainterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/painter")
public class PainterController {

    @Autowired
    PainterService painterService;

    @GetMapping("/painterPing")
    public String painterPing() {
        return "Painter pong";
    }

    @GetMapping("/painters")
    public List<Painter> getAllPainters(){
        return painterService.getAllPainters();
    }

    @GetMapping("/painter/{id}")
    public Painter getPainter(@PathVariable("id") int id) {
        return painterService.getPainterById(id);
    }

    @DeleteMapping("/painter/{id}")
    public void deletePainter(@PathVariable("id") int id) {
        painterService.deletePainterById(id);
    }

    @PostMapping("/painter")
    public void addPainter(@RequestBody Painter painter) {
        painterService.saveOrUpdate(painter);
    }

    @PutMapping("/painter")
    public void updatePainter(@RequestBody Painter painter) {
        painterService.saveOrUpdate(painter);
    }

}
