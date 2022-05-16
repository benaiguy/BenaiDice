package benaiguy.dice.operations;

import java.util.List;

public class ReplaceValueOperation extends DieOperation {

    private final int valueToReplace;
    private final int replacementValue;

    public ReplaceValueOperation(DieOperation operation, int valueToReplace, int replacementValue) {
        super(operation);
        this.valueToReplace = valueToReplace;
        this.replacementValue = replacementValue;
    }

    @Override
    protected List<Integer> resolve() {
        return operation.resolve().stream()
                .map(i -> i == valueToReplace ? replacementValue : i).toList();
    }
}
