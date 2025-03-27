package com.example.AddingMoreFeaturesDemo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Fox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    private int age;

    @ManyToMany(mappedBy = "foxFriendsList", cascade = CascadeType.ALL)
    private List<Bunny> bunnyFriendsList = new ArrayList<>();

    public Fox() {
    }

    public Fox(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Bunny> getBunnyFriendsList() {
        return bunnyFriendsList;
    }

    public void setBunnyFriendsList(List<Bunny> bunnyFriendsList) {
        this.bunnyFriendsList = bunnyFriendsList;
    }
}
