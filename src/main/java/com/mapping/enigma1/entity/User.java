package com.mapping.enigma1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column( name =  "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long unitId;

    private String userName;

    @ManyToMany(mappedBy = "users")
    List<Inventory> inventories = new ArrayList<>();


    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String unitName) {
        this.userName = unitName;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        return "User{" +
                "unitId=" + unitId +
                ", userName='" + userName + '\'' +
                ", inventories=" + inventories +
                '}';
    }
}
