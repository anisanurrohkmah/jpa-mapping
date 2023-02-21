package com.mapping.enigma1.repository;

import com.mapping.enigma1.entity.Inventory;

import java.util.List;

public interface IInventory {
    void insert(Inventory inv) throws Exception ;

    void delete(Inventory inv) throws  Exception;

    List<Inventory> getAll();

    List<Inventory> getLike(String like);

    List<Inventory> getPerPage(int page, int perpage);

    List<Inventory> getIn(String inside);

}
