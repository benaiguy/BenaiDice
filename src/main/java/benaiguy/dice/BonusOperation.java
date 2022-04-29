package benaiguy.dice;

import java.util.List;
import java.util.stream.Collectors;

public class BonusOperation extends DieOperation {

    private int value;

    public BonusOperation(DieOperation operation, int value) {
        super(operation);
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

    public int roll() {
        if (operation == null) {
            return value;
        } else {
            return value + operation.resolve().stream().reduce((0), Integer::sum);
        }
    }
}
