public class RandomOutTask implements Task {
    int randomNumber;

    public RandomOutTask() {
        randomNumber = (int)(Math.random() * 10) + 1;  //  Generate a random integer in range [1, 10]
    }

    @Override
    public void execute() {
        System.out.println(randomNumber);
    }
}
