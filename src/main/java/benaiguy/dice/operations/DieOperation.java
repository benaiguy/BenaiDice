package benaiguy.dice.operations;

import java.util.List;

public abstract class DieOperation {

    protected final DieOperation operation;

    DieOperation(DieOperation operation, boolean nullable) {
        if (!nullable && operation == null) {
            throw new IllegalArgumentException("This operation must be applied to another non-null operation.");
        }
        this.operation = operation;
    }

    protected abstract List<Integer> resolve();

    public int roll() {
        return resolve().stream().reduce((0), Integer::sum);
    }

}
