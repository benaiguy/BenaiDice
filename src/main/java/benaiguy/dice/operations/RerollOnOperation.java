package benaiguy.dice.operations;

import java.util.ArrayList;
import java.util.List;

public class RerollOnOperation extends DieOperation {

    private final int rerollValue;
    private final int numberOfRerolls;

    public RerollOnOperation(DieOperation operation, int rerollValue, int numberOfRerolls) {
        super(operation, false);
        if (numberOfRerolls < 1) {
            throw new IllegalArgumentException("Parameter \"numberOfRerolls\" must be greater than 0.");
        }
        this.rerollValue = rerollValue;
        this.numberOfRerolls = numberOfRerolls;
    }

    @Override
    protected List<Integer> resolve() {
        List<Integer> resolution = new ArrayList<>();
        resolution.add(operation.roll());
        for(int i = 0; i < numberOfRerolls && resolution.get(0) == rerollValue; i++) {
            resolution.set(0, operation.roll());
        }
        return resolution;
    }
}
