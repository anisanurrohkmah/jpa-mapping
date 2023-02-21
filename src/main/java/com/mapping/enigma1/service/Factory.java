package com.mapping.enigma1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class Factory {

    private static  EntityManagerFactory entityMF;

    private static  String NAME_PERSISTENCE ="Inventory";

    public static void getEntityMF() {
         entityMF = Persistence.createEntityManagerFactory(NAME_PERSISTENCE);
    }


    public static EntityManager startConnect(){
        if(entityMF==null){
            getEntityMF();
        }
        return entityMF.createEntityManager();

    }


    public static void closeConnect(){
        if(entityMF!=null){
            entityMF.close();
        }
    }



}
