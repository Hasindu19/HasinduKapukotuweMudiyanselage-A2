import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Ride class implementing RideInterface
public class Ride implements RideInterface{
    private String name;
    private int duration;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();//keep track of Visitors who are waiting to take the ride
    private LinkedList<Visitor> rideHistory = new LinkedList<>();//Visitors who have taken the ride
    private int maxRiders;//identify how many visitors a ride can take in one cycle
    private int numOfCycles;//identify how many times the ride is run
    private final Lock lock = new ReentrantLock();

    // Default constructor
    public Ride() {
        this.name = "";
        this.duration = 0;
        this.operator = null;
        this.maxRiders = 1; // Default to at least 1 rider
        this.numOfCycles = 0; // Default to 0 cycles
    }

    // Parameterized constructor
    public Ride(String name, int duration, Employee operator, int maxRiders) {
        this.name = name;
        this.duration = duration;
        this.operator = operator;
        this.maxRiders = maxRiders;
        this.numOfCycles = 0;
    }

    // Getters and setters
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

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // Assigns an operator to the ride
    public void assignOperator(Employee operator) {
        this.operator = operator;
    }

    @Override
    // Adds a visitor to the queue
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println("Visitor added to queue.");
    }

    // Removes a visitor from the queue
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.remove(visitor)) {
            System.out.println("Visitor removed from queue.");
        } else {
            System.out.println("Visitor not found in queue.");
        }
    }

    // Prints the list of visitors in the queue
    @Override
    public void printQueue() {
        System.out.println("Visitors in queue:");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName()+","+ visitor.getAge()+","+visitor.getId()+","+visitor.getTicketNumber()+","+visitor.getTicketType());
        }
    }

    // Runs one cycle of the ride
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

        lock.lock();// Acquire lock
        try {
            int riders = 0;
            while (riders < maxRiders && !visitorQueue.isEmpty()) {
                Visitor visitor = visitorQueue.poll();
                addVisitorToHistory(visitor);
                riders++;
            }
            numOfCycles++;
            System.out.println("Ride run successfully. Number of cycles: " + numOfCycles);
        } finally {
            lock.unlock();// Release lock
        }
    }

    // Adds a visitor to the ride history
    public void addVisitorToHistory(Visitor visitor) {
        lock.lock();// Acquire lock
        try {
            rideHistory.add(visitor);
            System.out.println("Visitor added to ride history.");
        } finally {
            lock.unlock();// Release lock
        }
    }

    // Checks if a visitor is in the ride history
    public boolean isVisitorInHistory(Visitor visitor) {
        lock.lock();// Acquire lock
        try {
            return rideHistory.contains(visitor);
        } finally {
            lock.unlock();// Release lock
        }
    }

    // Gets the number of visitors in the ride history
    public int getNumberOfVisitorsInHistory() {
        lock.lock();// Acquire lock
        try {
            return rideHistory.size();
        } finally {
            lock.unlock();// Release lock
        }
    }

    // Prints the ride history
    @Override
    public void printRideHistory() {
        lock.lock();// Acquire lock
        try {
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + "," + visitor.getTicketNumber() + "," + visitor.getTicketType());
            }
        } finally {
            lock.unlock();// Release lock
        }
    }

    // Sorts the ride history
    public void sortVisitors() {
        lock.lock();// Acquire lock
        try {
            Collections.sort(rideHistory, new VisitorComparator());
            System.out.println("Ride history sorted.");
        } finally {
            lock.unlock();// Release lock
        }
    }

    //method that writes the details of all the Visitor that have taken for the Ride
    public void writeRideHistoryToFile(String filename) {
        lock.lock();// Acquire lock
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + "," +
                        visitor.getTicketNumber() + "," + visitor.getTicketType());
                writer.newLine();
            }
            System.out.println("Ride history successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            lock.unlock();// Release lock
        }
    }

    //method to the Ride class that can read the file
    public void readRideHistoryFromFile(String filename) {
        lock.lock();// Acquire lock
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    String name = details[0];
                    int age = Integer.parseInt(details[1]);
                    String id = details[2];
                    String ticketNumber = details[3];
                    String ticketType = details[4];
                    Visitor visitor = new Visitor(name, age, id, ticketNumber, ticketType);
                    rideHistory.add(visitor);
                } else {
                    System.out.println("Invalid data format in file: " + line);
                }
            }
            System.out.println("Ride history successfully read from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing age: " + e.getMessage());
        } finally {
            lock.unlock();// Release lock
        }
    }


}
