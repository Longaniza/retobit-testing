import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setup() {
        student = new Student("Ivan", "chefcito@gmail.com", 19);
    }

    @Test
    @DisplayName("Getters tests")
    public void gettersTests() {
        assertEquals("Ivan", student.getName());
        assertEquals("chefcito@gmail.com", student.getEmail());
        assertEquals(19, student.getAge());
    }

    @Test
    @DisplayName("Setters tests")
    public void settersTests() {
        final String newName = "Jose";
        final String newEmail = "jose@gmail.com";
        final int newAge = 20;

        student.setName(newName);
        student.setEmail(newEmail);
        student.setAge(newAge);

        assertEquals(newName, student.getName());
        assertEquals(newEmail, student.getEmail());
        assertEquals(newAge, student.getAge());
    }

    @Test
    @DisplayName("Incorrect name tests")
    public void exceptionNameTests() {
        final String expectedExceptionMessage = "Name cannot be empty";
        IllegalArgumentException emptyException = assertThrows(IllegalArgumentException.class, () -> {
            student.setName("");
        });
        IllegalArgumentException nullException = assertThrows(IllegalArgumentException.class, () -> {
            student.setName(null);
        });

        assertEquals(expectedExceptionMessage, emptyException.getMessage());
        assertEquals(expectedExceptionMessage, nullException.getMessage());
    }

    @Test
    @DisplayName("Incorrect email tests")
    public void exceptionEmailTests() {
        final String expectedExceptionMessage = "Email must have a valid format";

        IllegalArgumentException atException = assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("chefcito.com");
        });
        IllegalArgumentException nullException = assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail(null);
        });

        assertEquals(expectedExceptionMessage, atException.getMessage());
        assertEquals(expectedExceptionMessage, nullException.getMessage());
    }

    @Test
    @DisplayName("Incorrect age tests")
    public void exceptionAgeTests() {
        final String expectedExceptionMessage = "Age must be between 0 and 120 years";

        IllegalArgumentException minException = assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(-1);
        });
        IllegalArgumentException maxException = assertThrows(IllegalArgumentException.class, () -> {
            student.setAge(121);
        });

        assertEquals(expectedExceptionMessage, minException.getMessage());
        assertEquals(expectedExceptionMessage, maxException.getMessage());
    }

    @Test
    @DisplayName("Adding grades happy path tests")
    public void addingGradesTests() {
        student.addGrade(9.9);
        student.addGrade(10.0);
        student.addGrade(7.5);
        student.addGrade(8.8);

        var grades = student.getGrades();
        assertFalse(student.getGrades().isEmpty());
        assertEquals(4, student.getGrades().size());
    }

    @Test
    @DisplayName("Incorrect grade tests")
    public void exceptionGradeTests() {
        final String expectedExceptionMessage = "Grade must be between 0.0 and 10.0";

        IllegalArgumentException minException = assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(-1);
        });
        IllegalArgumentException maxException = assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(10.1);
        });

        assertEquals(expectedExceptionMessage, minException.getMessage());
        assertEquals(expectedExceptionMessage, maxException.getMessage());
    }

    @Test
    @DisplayName("calculateAverage tests")
    public void averageGradesTest() {
        student.addGrade(9.9);
        student.addGrade(10.0);
        student.addGrade(7.5);
        student.addGrade(8.8);

        double average = student.calculateAverage();
        assertEquals(9.05, average);
    }

    @Test
    @DisplayName("isAdult tests")
    public void isAdultTest() {
        assertTrue(student.isAdult());
    }

    @Test
    @DisplayName("academicStatus tests")
    public void academicStatusTest() {
        student.addGrade(9.9);

        String status = student.getAcademicStatus();
        assertEquals("Excellent", status);
    }
}
