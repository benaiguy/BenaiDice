package benaiguy.dice.operations;

import java.util.List;

public class TwiceOperation extends DieOperation {

    public TwiceOperation(DieOperation operation) {
        super(operation);
    }

    @Override
    protected List<Integer> resolve() {
        return operation.resolve().stream().map(i -> i*2).toList();
    }
}
