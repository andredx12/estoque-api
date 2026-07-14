package com.andre.estoque_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.estoque_api.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByQuantidadeLessThan(Integer quantidade);

}