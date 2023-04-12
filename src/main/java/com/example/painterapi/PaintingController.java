//package com.example.painterapi;
//
//import com.example.painterapi.models.Painting;
//import com.example.painterapi.service.PaintingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/painting")
//public class PaintingController {
//
//        @Autowired
//        PaintingService paintingService;
//
//        @GetMapping("/paintingPing")
//        public String paintingPing() {
//            return "Painting pong";
//        }
//
//        @GetMapping("/paintings")
//        public List<Painting> getAllPaintings(){
//            return paintingService.getAllPaintings();
//        }
//}
