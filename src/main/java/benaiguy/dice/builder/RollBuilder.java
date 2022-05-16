package benaiguy.dice.builder;

import benaiguy.dice.operations.*;

public class RollBuilder implements IRollBuilder {
    private DieOperation dieOp;

    public RollBuilder() {
        dieOp = null;
    }

    @Override
    public IRollBuilder roll(int numberOfDice, int numberOfSides) {
        dieOp = new RollOperation(dieOp, numberOfDice, numberOfSides);
        return this;
    }

    @Override
    public IRollBuilder takeHighest(int numberToTake) {
        disallowNull();
        dieOp = new TakeHighestOperation(dieOp, numberToTake);
        return this;
    }

    @Override
    public IRollBuilder takeLowest(int numberToTake) {
        disallowNull();
        dieOp = new TakeLowestOperation(dieOp, numberToTake);
        return this;
    }

    @Override
    public IRollBuilder bonus(int bonus) {
        dieOp = new BonusOperation(dieOp, bonus);
        return this;
    }

    @Override
    public IRollBuilder twice() {
        disallowNull();
        dieOp = new TwiceOperation(dieOp);
        return this;
    }

    @Override
    public IRollBuilder half() {
        disallowNull();
        dieOp = new HalfOperation(dieOp);
        return this;
    }

    @Override
    public IRollBuilder rerollOn(int rerollValue, int numberOfRerolls) {
        disallowNull();
        dieOp = new RerollOnOperation(dieOp, rerollValue, numberOfRerolls);
        return this;
    }

    @Override
    public IRollBuilder replaceValue(int valueToReplace, int replacementValue) {
        disallowNull();
        dieOp = new ReplaceValueOperation(dieOp, valueToReplace, replacementValue);
        return this;
    }

    @Override
    public IRollBuilder group(DieOperation groupAddition) {
        disallowNull();
        dieOp = new GroupOperation(dieOp, groupAddition);
        return this;
    }

    @Override
    public DieOperation create() {
        DieOperation result = dieOp;
        dieOp = null;
        return result;
    }

    private void disallowNull() {
        if (dieOp == null) {
            throw new IllegalArgumentException("This operation cannot accept a null operation.");
        }
    }
}
