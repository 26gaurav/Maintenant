package com.project.maintenant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User", schema = "MunicipalityInitiative", catalog = "")
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "FirstName")
    private String firstName;

    @Basic
    @NotNull
    @Column(name = "LastName")
    private String lastName;

    @Basic
    @NotNull
    @Column(name = "AddressDetail", columnDefinition = "json")
    @JsonRawValue
    private String addressDetail;

    @Basic
    @NotNull
    @Column(name = "Email", unique=true)
    private String email;

    @Basic
    @NotNull
    @Column(name = "PhoneNumber", unique=true)
    private String phoneNumber;

    @Basic
    @NotNull
    @Column(name = "Age")
    private int age;

    @Basic
    @NotNull
    @Column(name = "Gender")
    private String gender;

    @Basic
    @NotNull
    @Column(name = "Username", unique=true)
    private String username;

    @Basic
    @NotNull
    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "userByCreatedBy")
    private List<ComplaintEntity> complaints;

    public UserEntity() {
    }

    public UserEntity(long id, String firstName, String lastName, String addressDetail, String email, String phoneNumber, int age, String gender, String username, String password, List<ComplaintEntity> complaints) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressDetail = addressDetail;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.complaints = complaints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonManagedReference
    public List<ComplaintEntity> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<ComplaintEntity> complaints) {
        this.complaints = complaints;
    }
}
