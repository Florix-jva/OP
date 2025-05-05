package MethodenUndKonstruktoren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    void throwDice_shouldReturnBetween1And6() {
        Dice dice = new Dice();
        for (int i = 0; i < 100; i++) {
            int result = dice.throwDice();
            assertTrue(result >= 1 && result <= 6, "Result must be between 1 and 6");
        }
    }
}
