package benaiguy.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RollOperation extends DieOperation {

    private int numberOfDice;
    private int numberOfSides;
    private ThreadLocalRandom rand;

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
                    .map(i -> (i % numberOfSides) + 1)
                    .collect(ArrayList::new, ArrayList::add, null);
        } else {
            List<Integer> resolution = operation.resolve();
            resolution.addAll(rand.ints().limit(numberOfDice)
                    .map(i -> (i % numberOfSides) + 1)
                    .collect(ArrayList::new, ArrayList::add, null));
            return resolution;
        }
    }

    @Override
    public int roll() {
        return 0;
    }
}
