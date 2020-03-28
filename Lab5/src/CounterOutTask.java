public class CounterOutTask implements Task {
    static int counter;

    public CounterOutTask() {
        counter = 0;
    }

    @Override
    public void execute() {
        counter += 1;
        System.out.printf("Current counter value: %d%n", counter);
    }
}
