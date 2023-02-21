package com.mapping.enigma1;

import com.mapping.enigma1.entity.*;
import com.mapping.enigma1.service.Factory;
import com.simplejpa.*;
import com.sun.tools.javac.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Arrays;

public class AppMapping {
    public static void main(String[] args)  {
//

        EntityManager em = Factory.startConnect();
       em.getTransaction().begin();
//

// ------jika begini, maka akan gagal, karena relasi nya di inventory one to one is by id, jadi harus diinput dlu inventorynya,
        // lalu ambil idnya, baru diupdate/merge isi data listnya
//        Maintenance main1= new Maintenance();
//        main1.setCaseName("Recolouring");
//        Maintenance main2= new Maintenance();
//        main2.setCaseName(("Recleaning"));
//        List<Maintenance> isiM = Arrays.asList(main1, main2);
//
//        //isi detail info
//        DetailInfo di = new DetailInfo();
//        di.setColour("purple");
//
//        Inventory iv = new Inventory();
//        iv.setMerk("Yosaka");
//        iv.setNameProduk("Umbrella");
//        iv.setPrice(2300000);
//        iv.setDetailInfo(di);
//        iv.setMaintenances(isiM);
//        em.merge(iv);
//        em.getTransaction().commit();



// ------ maka seperti ini
        // get dulu data inventori baru si update list nya
  // ini eror     Inventory getInv = em.find(Inventory.class, "510a7091-a487-4a9f-9617-dbcb19fbb4cf");
//          Inventory getInv = getInvById("510a7091-a487-4a9f-9617-dbcb19fbb4cf");
//
//            Maintenance main1= new Maintenance();
//            main1.setCaseName("Recolouring");
//            Maintenance main2= new Maintenance();
//            main2.setCaseName(("Recleaning"));
//            List<Maintenance> isiM = Arrays.asList(main1, main2);
//
//           getInv.setMaintenances(isiM);
//            em.merge(getInv);
//            em.getTransaction().commit();
//
// ---percobaan many to one-------

//        Unit units = new Unit();
//        units.setUnitName("Finance");
//        em.persist(units);
//        em.getTransaction().commit();
//
//        Inventory ins = new Inventory();
//        ins.setNameProduk("White Board");
//        ins.setPrice(16000);
//        ins.setMerk("Koala");
//        ins.setUnit(units);
//        em.getTransaction().begin();
//        em.persist(ins);
//        em.getTransaction().commit();

//----------------percobaan many to many
//        User user1 = new User();
//        user1.setUserName("Anr");
//        em.persist(user1);
//        em.getTransaction().commit();
//
//        Inventory invent = new Inventory();
//        invent.setMerk("Glass");
//        invent.setPrice(7500);
//        invent.setNameProduk("Pencil");
//        invent.getUsers().add(user1);
//
//        em.getTransaction().begin();
//        em.persist(invent);
//        em.getTransaction().commit();



//  ---------- percobaan add user list


        Inventory invenss = em.find(Inventory.class,"d363c729-0c27-477e-93ed-529fd1da424c");
        System.out.println(invenss.getNameProduk());

//
        User user2= new User();
        user2.setUserName("Fuji");
        user2.getInventories().add(invenss);
        invenss.getUsers().add(user2);
        em.persist(user2);
        em.getTransaction().commit();
        em.close();
//
//        EntityManager fm = Factory.startConnect();
//        List<Inventory> inven1 = fm.createQuery("select k from Inventory k", Inventory.class).getResultList();
//        for (Inventory i : inven1){
//            System.out.println(i);
//        }
////
//        List<User> use1 = fm.createQuery("select x from User x", User.class).getResultList();
//        for (User p : use1){
//            System.out.println(p);
//        }






    }


    public static Inventory getInvById(String id){
        EntityManager em = Factory.startConnect();
        Inventory result = em.find(Inventory.class, id);
        return result;
    }



}
