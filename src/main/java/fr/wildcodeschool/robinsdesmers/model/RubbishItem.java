package fr.wildcodeschool.robinsdesmers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class RubbishItem extends DateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer sumRubbish;
    private boolean atSea;
    private boolean collected;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    public RubbishItem() {
    }

    public RubbishItem(String title, String description, Integer sumRubbish, boolean atSea, boolean collected, Double latitude, Double longitude) {
        this.title = title;
        this.description = description;
        this.sumRubbish = sumRubbish;
        this.atSea = atSea;
        this.collected = collected;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSumRubbish() {
        return sumRubbish;
    }

    public void setSumRubbish(Integer sumRubbish) {
        this.sumRubbish = sumRubbish;
    }

    public boolean isAtSea() {
        return atSea;
    }

    public void setAtSea(boolean atSea) {
        this.atSea = atSea;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
