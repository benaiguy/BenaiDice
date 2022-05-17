package benaiguy.dice.operations;

import java.util.List;

public class BonusOperation extends DieOperation {

    private final int value;

    public BonusOperation(DieOperation operation, int value) {
        super(operation, true);
        this.value = value;
    }

    @Override
    protected List<Integer> resolve() {
        if (operation == null) {
            return List.of(value);
        } else {
            return List.of(value + operation.resolve().stream()
                    .reduce((0), Integer::sum));
        }
    }
}
