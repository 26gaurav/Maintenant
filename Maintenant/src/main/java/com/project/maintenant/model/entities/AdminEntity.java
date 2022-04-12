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


}
