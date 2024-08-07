public abstract class  Person {
    private String name;
    private int age;
    private String id;

    // Default constructor
    public Person(){
        this.name = "";
        this.age = 0;
        this.id = "";
    }

    // Parameterized constructor
    public Person(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = id;
    }

}
