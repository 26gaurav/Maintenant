package com.project.maintenant.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Complaint", schema = "MunicipalityInitiative", catalog = "")
public class ComplaintEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;

    @Basic
    @NotNull
    @Column(name = "Heading")
    private String heading;

    @Basic
    @NotNull
    @Column(name = "Description")
    private String description;

    @Basic
    @NotNull
    @Column(name = "IssueDate")
    private Timestamp issueDate;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ComplaintImage")
    private byte[] complaintImage;

    @Basic
    @NotNull
    @Column(name = "AddressDetail", columnDefinition = "json")
    @JsonRawValue
    private String addressDetail;

    @Basic
    @NotNull
    @Column(name = "ProgressLevel")
    private int progressLevel;

    @Basic
    @NotNull
    @Column(name = "ProgressDescription")
    private String progressDescription;

    @ManyToOne
    @JoinColumn(name = "CreatedBy", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByCreatedBy;

    @ManyToMany
    @JoinTable(
            name = "complaintMapping",
            joinColumns = @JoinColumn(name = "complaint_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id"))
    private List<WorkerEntity> assignedWorker;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public byte[] getComplaintImage() {
        return complaintImage;
    }

    public void setComplaintImage(byte[] complaintImage) {
        this.complaintImage = complaintImage;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public int getProgressLevel() {
        return progressLevel;
    }

    public void setProgressLevel(int progressLevel) {
        this.progressLevel = progressLevel;
    }

    public String getProgressDescription() {
        return progressDescription;
    }

    public void setProgressDescription(String progressDescription) {
        this.progressDescription = progressDescription;
    }

    @JsonBackReference
    public UserEntity getUserByCreatedBy() {
        return userByCreatedBy;
    }

    public void setUserByCreatedBy(UserEntity userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    @JsonManagedReference
    public List<WorkerEntity> getAssignedWorker() {
        return assignedWorker;
    }

    public void setAssignedWorker(List<WorkerEntity> assignedWorker) {
        this.assignedWorker = assignedWorker;
    }
}
