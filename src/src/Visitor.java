public class Visitor extends Person {
    private String ticketNumber;
    private String ticketType;

    // Default constructor
    public Visitor() {
        super();
        this.ticketNumber = "";
        this.ticketType = "";
    }

    // Parameterized constructor
    public Visitor(String name, int age, String id, String ticketNumber, String ticketType) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
    }

    // Getters and setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
