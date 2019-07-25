package fr.wildcodeschool.robinsdesmers.model;

import java.io.Serializable;

public class Authentication implements Serializable {
    private String error;
    private User user;

    public Authentication() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
