package fr.wildcodeschool.robinsdesmers.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<RubbishItem> rubbishItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CollectPointItem> collectPointItems;

    public User(String name) {
        this.name = name;
    }

    public User() {
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

    public List<RubbishItem> getRubbishItems() {
        return rubbishItems;
    }

    public void setRubbishItems(List<RubbishItem> rubbishItems) {
        this.rubbishItems = rubbishItems;
    }

    public List<CollectPointItem> getCollectPointItems() {
        return collectPointItems;
    }

    public void setCollectPointItems(List<CollectPointItem> collectPointItems) {
        this.collectPointItems = collectPointItems;
    }
}
