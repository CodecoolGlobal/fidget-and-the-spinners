package com.codecool.shophandlerservice.controller;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/addItemToShop")
    public void addItemToShopByCharacterIdAndCharacterLevel(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel){
        shopService.addItemToShopByCharacterIdAndCharacterLevel(characterId,characterLevel);
    }

    @GetMapping("/getItemsByCharacterId")
    public List<Item> getItemsByCharacterId(@RequestParam("characterId") Long characterId){
        return shopService.getItemsByCharacterId(characterId);
    }

    @PostMapping("/addMultipleItemsToShop")
    public void addMultipleItemsToShopByCharacterIdAndCharacterLevel(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel,@RequestParam("numberOfItems") Long numberOfItems){
        shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(characterId,characterLevel,numberOfItems);
    }

    @PutMapping("/refreshShop")
    public void refreshItemsByCharacterId(@RequestParam("characterId") Long characterId,@RequestParam("characterLevel") Long characterLevel) throws Exception {
        shopService.refreshItemsByCharacterId(characterId, characterLevel);
    }

    @GetMapping("/buyItem")
    public Item buyItem(@RequestParam("id") Long id){
        return shopService.pollItemById(id);
    }


}
