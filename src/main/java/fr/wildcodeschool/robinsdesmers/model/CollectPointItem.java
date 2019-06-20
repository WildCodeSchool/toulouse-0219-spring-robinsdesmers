package fr.wildcodeschool.robinsdesmers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CollectPointItem extends DateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer sommePoubelle;
    private Long latitude;
    private Long longitude;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    public CollectPointItem(String title, String description, Integer sommePoubelle, Long latitude, Long longitude) {
        this.title = title;
        this.description = description;
        this.sommePoubelle = sommePoubelle;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CollectPointItem() {
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

    public Integer getSommePoubelle() {
        return sommePoubelle;
    }

    public void setSommePoubelle(Integer sommePoubelle) {
        this.sommePoubelle = sommePoubelle;
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
