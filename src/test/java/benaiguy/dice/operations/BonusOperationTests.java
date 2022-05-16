package benaiguy.dice.operations;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BonusOperationTests {
    private BonusOperation op;

    @Test
    public void bonusOfFive_ResultsInFive() {
        op = new BonusOperation(null, 5);
        Assertions.assertEquals(5, op.roll());
    }

    @Test
    public void bonusChaining_SumsToTwenty() {
        op = new BonusOperation(null, 10);
        op = new BonusOperation(op, 15);
        op = new BonusOperation(op, 15);
        op = new BonusOperation(op, -20);
        Assertions.assertEquals(20, op.roll());
    }
}
