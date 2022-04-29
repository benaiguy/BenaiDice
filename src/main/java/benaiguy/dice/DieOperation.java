package benaiguy.dice;

import java.util.List;

public abstract class DieOperation {

    protected DieOperation operation;

    DieOperation(DieOperation operation) {
        this.operation = operation;
    }

    protected abstract List<Integer> resolve();

    public abstract int roll();

}
