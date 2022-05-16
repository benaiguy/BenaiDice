package benaiguy.dice.builder;

import benaiguy.dice.operations.DieOperation;

public interface IRollBuilder {

    IRollBuilder roll(int numberOfDice, int numberOfSides);

    IRollBuilder takeHighest(int numberToTake);

    IRollBuilder takeLowest(int numberToTake);

    IRollBuilder bonus(int bonus);

    IRollBuilder twice();

    IRollBuilder half();

    IRollBuilder rerollOn(int rerollValue, int numberOfRerolls);

    IRollBuilder group(DieOperation groupAddition);

    IRollBuilder replaceValue(int valueToReplace, int replacementValue);

    DieOperation create();

}
