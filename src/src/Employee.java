public class Employee extends Person{
    private String employeeId;
    private String position;

    public Employee(){
        super();
        this.employeeId = "";
        this.position = "";
    }
    public Employee(String name, int age, String address, String employeeId, String position) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
