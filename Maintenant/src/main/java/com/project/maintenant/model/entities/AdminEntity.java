package com.project.maintenant.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Admin", schema = "MunicipalityInitiative", catalog = "")
public class AdminEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "Password")
    private String password;

    @Basic
    @NotNull
    @Column(name = "Username")
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
