import java.util.Comparator;

// Comparator class for comparing Visitor objects
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare by ticket type first
        int result = v1.getTicketType().compareTo(v2.getTicketType());
        // If ticket types are the same, compare by name
        if (result == 0) {
            result = v1.getName().compareTo(v2.getName());
        }
        return result;// Return the comparison result
    }
}