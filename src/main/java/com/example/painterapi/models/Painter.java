package com.example.painterapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "painters")
public class Painter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int painter_id;
    private String name;
    private String nationality;
    private int birth_year;
    private int death_year;
    private String style;
    private String image_url;
    private String description;


    public int getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(int painter_id) {
        this.painter_id = painter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
