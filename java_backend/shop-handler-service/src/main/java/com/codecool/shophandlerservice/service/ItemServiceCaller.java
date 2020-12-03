package com.codecool.shophandlerservice.service;

import com.codecool.shophandlerservice.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceCaller {

    private final RestTemplate restTemplate;

    public ItemServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String itemHandlerUrl="http://localhost:8071/";//"http://item-handler-service/";
    //private final String itemHandlerUrl="http://item-handler-service/";

    public Item getItem(Long playerLevel){
        return restTemplate.getForEntity(itemHandlerUrl+playerLevel, Item.class).getBody();
    }


}