package com.codecool.shophandlerservice.repository;

import com.codecool.shophandlerservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findAllByCharacterId(Long characterId);

    Item getById(Long id);
}
