package guru.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.EmployeeModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;


public class JsonTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonTest() throws Exception {
        File file = new File("src/test/resources/test.json");

        EmployeeModel employee = objectMapper.readValue(file, EmployeeModel.class);

        Assertions.assertEquals(777, employee.getEmployeeId());
        Assertions.assertEquals("Виктор", employee.getFirstName());
        Assertions.assertEquals("Иванов", employee.getLastName());
        Assertions.assertEquals(32, employee.getAge());
        Assertions.assertNull(employee.getPatronymic());
        Assertions.assertEquals("MALE", employee.getGender());
        Assertions.assertEquals("hiking", employee.getHobbies().get(0));
        Assertions.assertEquals("swimming", employee.getHobbies().get(1));
        Assertions.assertEquals("sleeping", employee.getHobbies().get(2));

    }
}
