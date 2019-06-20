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
    private Integer sommeDechet;
    private boolean isAtSea;
    private boolean isCollected;
    private Long latitude;
    private Long longitude;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    public RubbishItem(String title, String description, Integer sommeDechet, boolean isAtSea, boolean isCollected, Long latitude, Long longitude) {
        this.title = title;
        this.description = description;
        this.sommeDechet = sommeDechet;
        this.isAtSea = isAtSea;
        this.isCollected = isCollected;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public RubbishItem() {
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

    public Integer getSommeDechet() {
        return sommeDechet;
    }

    public void setSommeDechet(Integer sommeDechet) {
        this.sommeDechet = sommeDechet;
    }

    public boolean isAtSea() {
        return isAtSea;
    }

    public void setAtSea(boolean atSea) {
        isAtSea = atSea;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
