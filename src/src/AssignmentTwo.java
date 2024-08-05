
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }

    public void partThree() {
        Ride ride = new Ride("Roller Coaster", 5, new Employee("John", 30, "E001", "Operator", 50000));
        Visitor visitor1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor visitor2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor visitor3 = new Visitor("Charlie", 22, "V003", "T003", "Bronze");
        Visitor visitor4 = new Visitor("David", 28, "V004", "T004", "Gold");
        Visitor visitor5 = new Visitor("Eva", 26, "V005", "T005", "Silver");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        ride.printQueue();
        ride.removeVisitorFromQueue(visitor3);
        ride.printQueue();
    }

}
