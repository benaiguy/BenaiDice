package benaiguy.dice.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RollOperation extends DieOperation {

    private final int numberOfDice;
    private final int numberOfSides;
    private final ThreadLocalRandom rand;

    public RollOperation(DieOperation operation, int numberOfDice, int numberOfSides) {
        super(operation);
        this.numberOfDice = numberOfDice;
        this.numberOfSides = numberOfSides;
        this.rand = ThreadLocalRandom.current();

    }

    @Override
    protected List<Integer> resolve() {
        if (operation == null) {
            return rand.ints().limit(numberOfDice)
                    .map(i -> (Math.abs(i) % numberOfSides) + 1)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        } else {
            List<Integer> resolution = operation.resolve();
            resolution.addAll(rand.ints().limit(numberOfDice)
                    .map(i -> (Math.abs(i) % numberOfSides) + 1)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
            return resolution;
        }
    }
}
