package com.example.painterapi;

import com.example.painterapi.models.Painter;
import com.example.painterapi.models.Painting;
import com.example.painterapi.service.PainterService;
import com.example.painterapi.service.PaintingService;
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

    @PostMapping(value = "/painting/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadImage(@PathVariable("id") int id, @RequestParam("file") MultipartFile file) {
        try {
            String fileName = "painting_" + id + ".png";
            Path path = Paths.get("../images/" + fileName);

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            String url = "http://localhost:8080/api/painting/" + id + "/image";

            Painting painting = paintingService.getPaintingById(id);
            if (painting == null) {
                return ResponseEntity.notFound().build();
            }
            painting.setImage_url(url);
            paintingService.saveOrUpdate(painting);

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping(value = "/painting/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        Painting painting = paintingService.getPaintingById(id);
        if (painting == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }

        String fileName = "painting_" + painting.getPainting_id() + ".png";
        InputStream inputStream = new FileInputStream("../images/" + fileName);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

}
