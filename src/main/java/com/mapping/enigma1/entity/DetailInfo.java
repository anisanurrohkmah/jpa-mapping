package com.mapping.enigma1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_detail")
public class DetailInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "no_detail")
    private String noDetail;

    private String colour;

//    @OneToOne(mappedBy = "detailInfo")
//    Inventory inventory;


    public String getNoDetail() {
        return noDetail;
    }

    public void setNoDetail(String noDetail) {
        this.noDetail = noDetail;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
