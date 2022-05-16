package benaiguy.dice.operations;

import java.util.List;

public class GroupOperation extends DieOperation {

    private final DieOperation otherOperation;

    public GroupOperation(DieOperation operation, DieOperation otherOperation) {
        super(operation);
        this.otherOperation = otherOperation;
    }

    @Override
    protected List<Integer> resolve() {
        List<Integer> resolution = operation.resolve();
        resolution.addAll(otherOperation.resolve());
        return resolution;
    }
}
