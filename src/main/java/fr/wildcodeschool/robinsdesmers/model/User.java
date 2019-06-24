package fr.wildcodeschool.robinsdesmers.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User extends DateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String dateOfBirth;
    private String department;
    private String category;
    private String pseudo;
    private String description;
    private int avatar;
    private int score;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<RubbishItem> rubbishItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CollectPointItem> collectPointItems;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String gender, String dateOfBirth, String department, String category, String pseudo, String description, int avatar, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.category = category;
        this.pseudo = pseudo;
        this.description = description;
        this.avatar = avatar;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
