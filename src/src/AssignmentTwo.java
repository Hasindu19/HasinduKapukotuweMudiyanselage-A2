
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partFourB();
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

    public void partFourA(){
        Ride ride = new Ride("Ferris Wheel", 10, new Employee("Jane", 35, "E002", "Operator", 60000));

    }

    public void partFourB(){
        Ride ride = new Ride("Bumper Cars", 8, new Employee("Bob", 40, "E003", "Operator", 55000));
        Visitor visitor1 = new Visitor("Zevin", 32, "V011", "T011", "Gold");
        Visitor visitor2 = new Visitor("Liam", 30, "V012", "T012", "Silver");
        Visitor visitor3 = new Visitor("Mia", 28, "V013", "T013", "Bronze");
        Visitor visitor4 = new Visitor("Nina", 26, "V014", "T014", "Gold");
        Visitor visitor5 = new Visitor("Oscar", 24, "V015", "T015", "Silver");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        System.out.println("Before sorting:");
        ride.printRideHistory();

        ride.sortVisitors();

        System.out.println("After sorting:");
        ride.printRideHistory();
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }

}
