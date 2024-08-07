
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partSix();
    }

    public void partThree() {
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "123", "Operator", 50000), 5, 0);
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
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "123", "Operator", 50000), 5, 0);
        Visitor visitor1 = new Visitor("Frank", 23, "V006", "T006", "Bronze");
        Visitor visitor2 = new Visitor("Grace", 21, "V007", "T007", "Silver");
        Visitor visitor3 = new Visitor("Hank", 24, "V008", "T008", "Gold");
        Visitor visitor4 = new Visitor("Ivy", 27, "V009", "T009", "Bronze");
        Visitor visitor5 = new Visitor("Jack", 29, "V010", "T010", "Silver");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        System.out.println("Is Hank in history? " + ride.isVisitorInHistory(visitor3));
        System.out.println("Number of visitors in history: " + ride.getNumberOfVisitorsInHistory());
        ride.printRideHistory();

    }

    public void partFourB(){
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "123", "Operator", 50000), 5, 0);
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
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "123", "Operator", 50000), 5, 0);

        ride.addVisitorToQueue(new Visitor("Alice", 25, "V101", "T001", "Regular"));
        ride.addVisitorToQueue(new Visitor("Bob", 30, "V102", "T002", "VIP"));
        ride.addVisitorToQueue(new Visitor("Charlie", 22, "V103", "T003", "Regular"));
        ride.addVisitorToQueue(new Visitor("David", 28, "V104", "T004", "VIP"));
        ride.addVisitorToQueue(new Visitor("Eve", 26, "V105", "T005", "Regular"));
        ride.addVisitorToQueue(new Visitor("Frank", 27, "V106", "T006", "VIP"));
        ride.addVisitorToQueue(new Visitor("Grace", 24, "V107", "T007", "Regular"));
        ride.addVisitorToQueue(new Visitor("Hank", 29, "V108", "T008", "VIP"));
        ride.addVisitorToQueue(new Visitor("Ivy", 23, "V109", "T009", "Regular"));
        ride.addVisitorToQueue(new Visitor("Jack", 21, "V110", "T010", "VIP"));

        //Print all Visitors in the queue.
        ride.printQueue();

        //Run one cycle
        System.out.println("\nRunning one cycle:");
        ride.runOneCycle();

        //Print al lVisitors in the queue after one cycle is run
        System.out.println("\nVisitors in queue after one cycle:");
        ride.printQueue();

        //Print all Visitor in ride history
        System.out.println("\nVisitors in ride history:");
        ride.printRideHistory();

    }

    public void partSix(){


    }

    public void partSeven(){
    }

}
