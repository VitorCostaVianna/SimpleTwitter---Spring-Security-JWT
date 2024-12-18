package com.vitor.springsecurity.entities;

import jakarta.persistence.*;


@Entity
@Table(name = Role.TABLE_NAME)
public class Role {
    
    private static final String TABLE_NAME = "tb_roles";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    private String name;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        
        BASIC(2l),  
        ADMIN(1l);

        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }

        public long getRoleId() {
            return roleId;
        }   
    }
}
