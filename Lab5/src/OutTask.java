public class OutTask implements Task {
    String message;

    public OutTask() {
        message = "Accessing execute() from OutTask";
    }

    @Override
    public void execute() {
        System.out.println(message);
    }
}
