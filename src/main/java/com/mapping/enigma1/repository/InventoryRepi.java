package com.mapping.enigma1.repository;

import com.mapping.enigma1.entity.Inventory;
import com.mapping.enigma1.service.TransactEm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Arrays;
import java.util.List;

public class InventoryRepi extends TransactEm implements IInventory {


    EntityManager em2;
    public InventoryRepi(EntityManager em) {
        super(em);
    }

    @Override
    public void delete(Inventory inv) throws Exception {
        TransactTo(em -> em.remove(inv));
    }


    @Override
    public void insert(Inventory inv) throws Exception  {
        TransactTo(em -> {
            em.persist(inv);
        });
//        em.persist(inv);
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> rows = em2.createQuery("select i from Inventory i", Inventory.class).getResultList();
        return rows;
    }

    @Override
    public List<Inventory> getLike(String like) {
        TypedQuery<Inventory> query = em2.createQuery("select w from inventory w where w.merk like?1", Inventory.class);
        query.setParameter(1,"%"+like+"%");
        return query.getResultList();
    }

    @Override
    public List<Inventory> getPerPage(int page, int size) {
        TypedQuery<Inventory> query = em2.createNamedQuery("inventory.findAll", Inventory.class);
        query.setFirstResult((page-1)*size);
        query.setMaxResults(size);
        return query.getResultList();



    }

    @Override
    public List<Inventory> getIn(String inside) {
        TypedQuery<Inventory> query = em2.createQuery("select w from inventory w where w.merk in(:inside)", Inventory.class);
        query.setParameter("inside", Arrays.asList(inside));
        return query.getResultList();

    }
}
