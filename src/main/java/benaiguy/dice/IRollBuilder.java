package benaiguy.dice;

public interface IRollBuilder {

    void roll(int numberOfDice, int numberOfSides);

    void takeHighest(int numberToTake);

    void takeLowest(int numberToTake);

    void save(int difficultyClass, DieOperation onSuccess, DieOperation onFail);

    void bonus(int bonus);

    void twice();

    void half();

    void rerollOn(int rerollValue, int numberOfRerolls);

    void group(DieOperation groupAddition);

    void replaceValue(int valueToReplace, int replacementValue);

    DieOperation create();

}
