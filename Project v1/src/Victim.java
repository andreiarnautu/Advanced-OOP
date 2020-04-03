public class Victim extends Person {
    private String causeOfDeath;

    public Victim(String causeOfDeath) {
        super();
        this.causeOfDeath = causeOfDeath;
    }

    public Victim(String causeOfDeath, String victimName, Integer age) {
        super(victimName, age);
        this.causeOfDeath = causeOfDeath;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }
}
