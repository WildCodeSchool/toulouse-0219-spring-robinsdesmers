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
    private Integer sumCollectPoint;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    public CollectPointItem(String title, String description, Integer sumCollectPoint, Double latitude, Double longitude) {
        this.title = title;
        this.description = description;
        this.sumCollectPoint = sumCollectPoint;
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

    public Integer getSumCollectPoint() {
        return sumCollectPoint;
    }

    public void setSumCollectPoint(Integer sumCollectPoint) {
        this.sumCollectPoint = sumCollectPoint;
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
