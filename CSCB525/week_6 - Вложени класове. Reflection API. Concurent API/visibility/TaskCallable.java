package visibility;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {
    private int number = 10;

    @Override
    public Integer call() throws Exception {
        return number;
    }
}
