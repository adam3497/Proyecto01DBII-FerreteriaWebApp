package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles_webapp")
public class RoleEntity implements Serializable {

    @Id
    @Column(name = "role_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
    private List<UserEntity> users;

    public RoleEntity() {
    }

    public RoleEntity(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return String.format("Role[id=%d, name='%s']",
                id, roleName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
