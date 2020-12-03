package com.codecool.apigateway.service;

import com.codecool.apigateway.model.Player;
import com.codecool.apigateway.model.UserCredentials;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final RestTemplate restTemplate;

    @Value("${user.handler.service.url}")
    private String baseUrl;

    public Player findUserById(Long id) {
        return restTemplate.getForEntity(baseUrl + "player/" + id, Player.class).getBody();
    }

    public Player findByUsername(String username) {
        return restTemplate.getForEntity(baseUrl + username, Player.class).getBody();
    }

    public List<Player> findAllPlayers() {
        PlayerList response = restTemplate.getForObject(baseUrl + "player/all", PlayerList.class);
        assert response != null;
        return response.getPlayers();
    }

    public void registerNewPlayerData(UserCredentials player) {
        restTemplate.postForEntity(baseUrl + "register", player, String.class);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlayerList {
        private List<Player> players;
    }

}
