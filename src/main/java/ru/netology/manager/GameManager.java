package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.data.PlayerData;
import ru.netology.exception.NotRegisteredException;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameManager {
    private Map<String, PlayerData> players = new HashMap<>();

    public void register(String name, PlayerData player) {
        players.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        PlayerData playerOne = players.get(playerName1.toLowerCase());
        PlayerData playerTwo = players.get(playerName2.toLowerCase());
        if (playerOne == null) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован для участия в турнире!");
        } else if (playerTwo == null) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован для участия в турнире!");
        }
        if (playerOne.getStrength() > playerTwo.getStrength()) {
            return 1;
        } else if (playerOne.getStrength() < playerTwo.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
