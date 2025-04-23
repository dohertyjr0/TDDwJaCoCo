import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {
    @Test
    void testValidPassengerCreation() {
        Passenger p = new Passenger("Ms", "Alice", "Smith");
        assertEquals("Ms", p.getTitle());
        assertEquals("Alice", p.getFirstName());
        assertEquals("Smith", p.getLastName());
    }

    @Test
    void testInvalidTitle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Dr", "Alice", "Smith");
        });
        assertEquals("Invalid title. Must be Mr, Mrs, or Ms.", exception.getMessage());
    }

    @Test
    void testShortFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Mr", "Al", "Smith");
        });
        assertEquals("First name must be at least 3 characters long.", exception.getMessage());
    }

    @Test
    void testShortLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Mrs", "Alice", "Li");
        });
        assertEquals("Last name must be at least 3 characters long.", exception.getMessage());
    }
}
