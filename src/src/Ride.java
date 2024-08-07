import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface{
    private String name;
    private int duration;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int maxRiders;
    private int numOfCycles;

    public Ride() {
        this.name = "";
        this.duration = 0;
        this.operator = null;
        this.maxRiders = 1; // Default to at least 1 rider
        this.numOfCycles = 0; // Default to 0 cycles
    }

    public Ride(String name, int duration, Employee operator, int maxRiders, int numOfCycles) {
        this.name = name;
        this.duration = duration;
        this.operator = operator;
        this.maxRiders = maxRiders;
        this.numOfCycles = 0;
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

        int riders = 0;
        while (!visitorQueue.isEmpty() && riders < maxRiders) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToHistory(visitor);
            riders++;
        }
        numOfCycles++;
        System.out.println("Ride run for one cycle with " + riders + " visitors.");
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

    //method that writes the details of all the Visitor that have taken for the Ride
    public void writeRideHistoryToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getId() + "," +
                        visitor.getTicketNumber() + "," + visitor.getTicketType());
                writer.newLine();
            }
            System.out.println("Ride history successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    //method to the Ride class that can read the file
    public void readRideHistoryFromFile(String filename) {
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
                    rideHistory.add(visitor);// Add to ride history
                } else {
                    System.out.println("Invalid data format in file: " + line);
                }
            }
            System.out.println("Ride history successfully read from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing age: " + e.getMessage());
        }
    }


}
