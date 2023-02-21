//package com.enigma.entity;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "tbl_inventory")
//public class Inventory {
//
//
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id_inventaris")
//    private  String code;
//
//    @Column(name = "nama_produk", nullable = false, length = 200)
//    private  String nameProduk;
//    private  String merk;
//    private  Integer price;
//
//    @Column(name = "date_purchase")
//    @Temporal(TemporalType.DATE)
//    private Date datePurchase;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getNameProduk() {
//        return nameProduk;
//    }
//
//    public void setNameProduk(String nameProduk) {
//        this.nameProduk = nameProduk;
//    }
//
//    public String getMerk() {
//        return merk;
//    }
//
//    public void setMerk(String merk) {
//        this.merk = merk;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public Date getDatePurchase() {
//        return datePurchase;
//    }
//
//    public void setDatePurchase(Date datePurchase) {
//        this.datePurchase = datePurchase;
//    }
//
//    @Override
//    public String toString() {
//        return "Inventory{" +
//                "code='" + code + '\'' +
//                ", nameProduk='" + nameProduk + '\'' +
//                ", merk='" + merk + '\'' +
//                ", price=" + price +
//                ", datePurchase=" + datePurchase +
//                '}';
//    }
//}
