package benaiguy.dice.operations;

import java.util.List;

public class HalfOperation extends DieOperation {

    public HalfOperation(DieOperation operation) {
        super(operation, false);
    }

    @Override
    protected List<Integer> resolve() {
        return operation.resolve().stream().map(i -> i/2).toList();
    }
}
