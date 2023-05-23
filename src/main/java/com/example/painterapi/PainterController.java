package com.example.painterapi;

import com.example.painterapi.models.Painter;
import com.example.painterapi.service.PainterService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
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
    public String addPainter(@RequestBody Painter painter) {
        painterService.saveOrUpdate(painter);
        return "painter '" + painter.getName() + "' added with id " + painter.getPainter_id();
    }

    @PutMapping("/painter")
    public void updatePainter(@RequestBody Painter painter) {
        painterService.saveOrUpdate(painter);
    }

    @PostMapping(value = "/painter/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadImage(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
        try {
            String fileName = "painter_" + id + ".png";
            Path path = Paths.get("../images/" + fileName);

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            String url = "http://localhost:8080/api/painter/" + id + "/image";

            Painter painter = painterService.getPainterById(id);
            if (painter == null) {
                return ResponseEntity.notFound().build();
            }
            painter.setImage_url(url);
            painterService.saveOrUpdate(painter);

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping(value = "/painter/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        Painter painter = painterService.getPainterById(id);
        if (painter == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }

        String fileName = "painter_" + painter.getPainter_id() + ".png";
        InputStream inputStream = new FileInputStream("../images/" + fileName);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }
}
