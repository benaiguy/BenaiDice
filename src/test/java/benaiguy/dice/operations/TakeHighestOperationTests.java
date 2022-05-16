package benaiguy.dice.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TakeHighestOperationTests {
    private TakeHighestOperation op;
    private static Random rand;

    @BeforeAll
    public static void setup() {
        rand = new Random();
    }

    @BeforeEach
    public void setupEach() {
        op = null;
    }

    @Test
    public void testTakesCorrectNumber_WhenEnoughAvailable() {
        for (int i = 0; i < 20; i++) {
            int number = rand.nextInt(1, 5);
            op = new TakeHighestOperation(new RollOperation(null,4, 8), number);
            Assertions.assertEquals(op.resolve().size(), number);
        }
    }

    @Test
    public void takeHighestZero_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            op = new TakeHighestOperation(new RollOperation(null, 4, 8), 0);
        });
    }

    @Test
    public void testTakesCorrectNumber_WhenNotEnoughAvailable() {
        int availableDice = 4;
        for (int i = 0; i < 20; i++) {
            int number = rand.nextInt(4, 8);
            op = new TakeHighestOperation(new RollOperation(null, availableDice, 8), number);
            Assertions.assertEquals(availableDice, op.resolve().size());
        }
        ArrayList<Integer> list = new ArrayList(List.of(new Integer[]{4, 32, 5, 6, 47, 86}));
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void testTakeHighest_TakesHighestValues() {
//        GroupOperation groupOp = new GroupOperation(new BonusOperation(null, 5), new BonusOperation(null, 3));
//        op = new TakeHighestOperation(groupOp, 1);
        Assertions.assertEquals(5, op.roll());
    }
}
