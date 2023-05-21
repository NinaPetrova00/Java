package university;

//@Deprecated
public class Student extends Person implements Register {
    public String test;
    private String fNumber;

    public Student() {
    }

    public Student(String name, int age, String fNumber) {
        super(name, age);
        this.fNumber = fNumber;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    private String privateMessage() {
        return "Private message!";
    }

    private String privateMessageWithParam(String message) {
        return message;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fNumber='" + fNumber + '\'' +
                '}';
    }

    @Deprecated
    @Override
    public void register() {
        System.out.println("Registered");
    }
}
