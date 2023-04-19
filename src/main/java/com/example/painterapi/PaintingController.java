package com.example.painterapi;

import com.example.painterapi.models.Painter;
import com.example.painterapi.models.Painting;
import com.example.painterapi.service.PainterService;
import com.example.painterapi.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaintingController {

    @Autowired
    PaintingService paintingService;

    @Autowired
    PainterService painterService;

    @GetMapping("/paintings")
    public List<Painting> getAllPaintings() {
        return paintingService.getAllPaintings();
    }

    @GetMapping("painting/{id}")
    public Painting getPaintingById(@PathVariable int id) {
        return paintingService.getPaintingById(id);
    }

    @PostMapping("/painting")
    public void addPainting(@RequestBody Painting painting) {
        // Get the corresponding painter by id and set it in the painting object
        Painter painter = painterService.getPainterById(painting.getPainter().getPainter_id());
        painting.setPainter(painter);
        paintingService.saveOrUpdate(painting);
    }



}
