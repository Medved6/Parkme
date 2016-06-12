package com.example.sergewsevolojsky.parkme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sergewsevolojsky on 12/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResult {
    private User[] users;

    public User[] getUsers() { return users; }

    public void setUsers(User[] users) { this.users = users; }
}