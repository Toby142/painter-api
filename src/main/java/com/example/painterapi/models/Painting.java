//package com.example.painterapi.models;
//import com.example.painterapi.models.Painter;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Painting {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int painting_id;
//
//    private String title;
//
//    private int year;
//
//    private String image_url;
//
////    @ManyToOne
////    @JoinColumn(name = "painter_id")
////    private Painter painter;
//
//    public Painting() {
//    }
//
//    public Painting(String title, int year, String image_url, Painter painter) {
//        this.title = title;
//        this.year = year;
//        this.image_url = image_url;
////        this.painter = painter;
//    }
//
//    public int getPainting_id() {
//        return painting_id;
//    }
//
//    public void setPainting_id(int id) {
//        this.painting_id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public String getImage_url() {
//        return image_url;
//    }
//
//    public void setImage_url(String image_url) {
//        this.image_url = image_url;
//    }
//
////    public Painter getPainter() {
////        return painter;
////    }
////
////    public void setPainter(Painter painter) {
////        this.painter = painter;
////    }
//}
