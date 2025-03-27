package com.example.AddingMoreFeaturesDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bunny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String color;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bunny_fox",
            joinColumns = @JoinColumn(name = "bunny_id"),
            inverseJoinColumns = @JoinColumn(name = "fox_id")
    )
    @JsonIgnoreProperties("bunnyFriendsList")
    private List<Fox> foxFriendsList = new ArrayList<>();

    public Bunny() {
    }

    public Bunny(String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Fox> getFoxFriendsList() {
        return foxFriendsList;
    }

    public void setFoxFriendsList(List<Fox> foxFriendsList) {
        this.foxFriendsList = foxFriendsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bunny{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
