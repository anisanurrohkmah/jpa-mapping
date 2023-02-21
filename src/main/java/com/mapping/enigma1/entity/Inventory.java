package com.mapping.enigma1.entity;

import com.simplejpa.Assignment;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_inventory")
public class Inventory {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "code_inventaris")
    private  String code;

    @Column(name = "nama_produk", nullable = false, length = 200)
    private  String nameProduk;

    private  String merk;

    private Integer price;


    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "no_detail")
    private  DetailInfo detailInfo;

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "code_inventaris")
    List<Maintenance> maintenances;


//    @OneToMany
//    @JoinColumn(name = "id_maintenance")
//    List<Maintenance> maintenances;

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;


    @ManyToMany
    @JoinTable(name = "t_user_inventory",
                joinColumns = @JoinColumn(name = "code_inventaris"),
                 inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users = new ArrayList<>();


    public Unit getUnit() {
        return unit;
    }




    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameProduk() {
        return nameProduk;
    }

    public void setNameProduk(String nameProduk) {
        this.nameProduk = nameProduk;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public DetailInfo getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(DetailInfo detailInfo) {
        this.detailInfo = detailInfo;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "code='" + code + '\'' +
                ", nameProduk='" + nameProduk + '\'' +
                ", merk='" + merk + '\'' +
                ", price=" + price +
                ", detailInfo=" + detailInfo +
                ", maintenances=" + maintenances +
                ", unit=" + unit +
                ", users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
