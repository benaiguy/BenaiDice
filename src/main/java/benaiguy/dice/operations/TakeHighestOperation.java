package benaiguy.dice.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TakeHighestOperation extends DieOperation {
    private final int numberToTake;

    public TakeHighestOperation(DieOperation operation, int numberToTake) throws IllegalArgumentException {
        super(operation, false);
        if (numberToTake < 1) {
            throw new IllegalArgumentException("Parameter \"numberToTake\" must be greater than 0");
        }
        this.numberToTake = numberToTake;
    }

    @Override
    protected List<Integer> resolve() {
        ArrayList<Integer> resolution = (ArrayList<Integer>) operation.resolve();
        Collections.sort(resolution);
        Collections.reverse(resolution);
        if (numberToTake < resolution.size()) {
            resolution = (ArrayList<Integer>) resolution.subList(0, numberToTake);
        }
        return resolution;
    }
}
