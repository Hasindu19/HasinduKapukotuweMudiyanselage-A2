import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int result = v1.getTicketType().compareTo(v2.getTicketType());
        if (result == 0) {
            result = v1.getName().compareTo(v2.getName());
        }
        return result;
    }
}