import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface{
    private String name;
    private int duration;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

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

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println("Visitor added to queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.remove(visitor)) {
            System.out.println("Visitor removed from queue.");
        } else {
            System.out.println("Visitor not found in queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors in queue:");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName()+","+ visitor.getAge()+","+visitor.getId()+","+visitor.getTicketNumber()+","+visitor.getTicketType());
        }
    }


    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned to the ride.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }
        Visitor visitor = visitorQueue.poll();
        rideHistory.add(visitor);
        System.out.println("Ride run for one cycle with visitor: " + visitor);
    }


    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor added to ride history.");
    }

    public boolean isVisitorInHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    public int getNumberOfVisitorsInHistory() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName()+","+ visitor.getAge()+","+visitor.getId()+","+visitor.getTicketNumber()+","+visitor.getTicketType());
        }
    }

    public void sortVisitors() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history sorted.");
    }


}
