package benaiguy.dice;

public class RollBuilder implements IRollBuilder {
    private DieOperation dieOp;

    public RollBuilder() {
        dieOp = null;
    }

    @Override
    public void roll(int numberOfDice, int numberOfSides) {

    }

    @Override
    public void takeHighest(int numberToTake) {

    }

    @Override
    public void takeLowest(int numberToTake) {

    }

    @Override
    public void save(int difficultyClass, DieOperation onSuccess, DieOperation onFail) {

    }

    @Override
    public void bonus(int bonus) {

    }

    @Override
    public void twice() {

    }

    @Override
    public void half() {

    }

    @Override
    public void rerollOn(int rerollValue, int numberOfRerolls) {

    }

    @Override
    public void replaceValue(int valueToReplace, int replacementValue) {

    }

    @Override
    public void group(DieOperation groupAddition) {

    }

    @Override
    public DieOperation create() {
        DieOperation result = dieOp;
        dieOp = null;
        return result;
    }
}
