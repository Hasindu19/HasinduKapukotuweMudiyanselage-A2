public class Ride {
    private String name;
    private int duration;
    private Employee operator;

    public Ride() {
        this.name = "";
        this.duration = 0;
        this.operator = null;
    }

    public Ride(String name, int duration, Employee operator) {
        this.name = name;
        this.duration = duration;
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public void assignOperator(Employee operator) {
        this.operator = operator;
    }

}
