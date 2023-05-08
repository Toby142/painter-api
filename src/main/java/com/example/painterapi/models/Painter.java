package com.example.painterapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Painter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int painter_id;
    private String name;
    private String nationality;

    private String birth_date;
    private String death_date;
    private String style;
    private String image_url;
    private String description;

    @OneToMany(mappedBy = "painter", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Painting> paintings = new ArrayList<>();

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

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getDeath_date() {
        return death_date;
    }

    public void setDeath_date(String death_date) {
        this.death_date = death_date;
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


    @JsonIgnoreProperties("painter")
    public List<Painting> getPaintings() {
        return paintings;
    }

    @JsonBackReference
    public void setPaintings(List<Painting> paintings) {
        this.paintings = paintings;
    }

}
