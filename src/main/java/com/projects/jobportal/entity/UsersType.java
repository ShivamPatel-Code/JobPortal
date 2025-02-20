package com.projects.jobportal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userTypeId;

    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
    private List<Users> users;

    public UsersType() {}

    public UsersType(String userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersType{" +
                "userTypeId='" + userTypeId + '\'' +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
