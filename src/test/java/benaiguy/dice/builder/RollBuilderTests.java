package benaiguy.dice.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class RollBuilderTests {
    private static IRollBuilder builder;

    @BeforeAll
    public static void setupAll() {
        builder = new RollBuilder();
    }

    @BeforeEach
    public void setup() {
        builder.create();
    }

    @Test
    public void rollFromNull_NoExceptionThrowm() {
        try {
            builder.roll(4, 8);
        } catch (Exception e) {
            assert(false);
        }
        assert(true);
    }

    @Test
    public void bonusFromNull_NoExceptionThrown() {
        try {
            builder.bonus(5);
        } catch (Exception e) {
            assert(false);
        }
        assert(true);
    }

    @Test
    public void takeHighestFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.takeHighest(5));
    }

    @Test
    public void takeLowestFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.takeLowest(5));
    }

    @Test
    public void twiceFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.twice());
    }

    @Test
    public void halfFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.half());
    }

    @Test
    public void rerollOnFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.rerollOn(5, 5));
    }

    @Test
    public void replaceValueFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.replaceValue(5, 5));
    }

    @Test
    public void groupFromNull_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->builder.group(null));
    }

}
