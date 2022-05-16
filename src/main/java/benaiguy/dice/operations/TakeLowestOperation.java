package benaiguy.dice.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TakeLowestOperation extends DieOperation {

    private final int numberToTake;

    public TakeLowestOperation(DieOperation operation, int numberToTake) {
        super(operation);
        this.numberToTake = numberToTake;
    }

    @Override
    protected List<Integer> resolve() {
        if (operation == null) {
            throw new IllegalStateException();
        } else {
            ArrayList<Integer> resolution = (ArrayList<Integer>) operation.resolve();
            Collections.sort(resolution);
            if (numberToTake < resolution.size()) {
                resolution = (ArrayList<Integer>) resolution.subList(0, numberToTake);
            }
            return resolution;
        }
    }
}
