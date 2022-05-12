package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.PlayerData;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameManagerTest {
    GameManager manager = new GameManager();
    PlayerData playerOne = new PlayerData(1, "Вася-чемпион", 100);
    PlayerData playerTwo = new PlayerData(2, "Иван", 90);
    PlayerData playerThree = new PlayerData(3, "Петя", 90);

    @BeforeEach
    void setup() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);
    }

    @Test
    void shouldFirstPlayerWin() {
        assertEquals(1, manager.round("ВаСя-ЧеМпИоН", "иВаН"));
    }

    @Test
    void shouldSecondPlayerWin() {
        assertEquals(2, manager.round("пЕтЯ", "ВаСя-ЧеМпИоН"));
    }

    @Test
    void shouldDraw() {
        assertEquals(0, manager.round("пЕтЯ", "иВаН"));
    }

    @Test
    void shouldThrowNotRegisteredExceptionOne() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("ВаСя-ЧеМпИоН", "Антон");
        });
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Антон", "ВаСя-ЧеМпИоН");
        });
    }
}