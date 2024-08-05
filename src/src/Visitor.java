public class Visitor extends Person {
    private String ticketNumber;
    private String ticketType;

    public Visitor() {
        super();
        this.ticketNumber = "";
        this.ticketType = "";
    }

    public Visitor(String name, int age, String id, String ticketNumber, String ticketType) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
    }

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
