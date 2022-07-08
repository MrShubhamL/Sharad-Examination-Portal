package com.exam.model;

import jakarta.persistence.*;
import org.apache.catalina.User;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public Role(long roleId, String roleName, Set userRole) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRole = userRole;
    }

    public Role() {
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
