package com.mapping.enigma1.service;

import jakarta.persistence.EntityManager;

import java.util.function.Consumer;

public abstract class TransactEm {
    EntityManager em;

    public TransactEm(EntityManager em) {
        this.em = em;
    }

    public void TransactTo(Consumer<EntityManager> nameAction) throws Exception{
        em.getTransaction();
        nameAction.accept(em);
        em.getTransaction().commit();
    }

}
