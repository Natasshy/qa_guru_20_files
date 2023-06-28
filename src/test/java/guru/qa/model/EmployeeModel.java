package guru.qa.model;

import java.util.List;

public class EmployeeModel {
    private int employeeId;
    private String firstName;
    private String lastName;

    private int age;
    private String patronymic;
    private String gender;
    private List<String> hobbies;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }


}
