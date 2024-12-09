import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    void testAddContact() {
        assertEquals(1, phoneBook.add("Alice", "12345"));
        assertEquals(2, phoneBook.add("Bob", "67890"));
        assertEquals(2, phoneBook.add("Alice", "54321")); // Дубликат не добавляется
    }
    @Test
    void testFindByNumber() {
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");
        assertEquals("Alice", phoneBook.findByNumber("12345"));
        assertEquals("Bob", phoneBook.findByNumber("67890"));
        assertNull(phoneBook.findByNumber("00000")); // Номер не найден
    }
    @Test
    void testFindByName() {
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");
        assertEquals("12345", phoneBook.findByName("Alice"));
        assertEquals("67890", phoneBook.findByName("Bob"));
        assertNull(phoneBook.findByName("Charlie")); // Имя не найдено
    }
    @Test
    void testPrintAllNames() {
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");
        phoneBook.add("Charlie", "11111");

        // Перенаправляем стандартный вывод для проверки
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        phoneBook.printAllNames();
        String expectedOutput = "Alice" + System.lineSeparator() +
                "Bob" + System.lineSeparator() +
                "Charlie" + System.lineSeparator(); // Ожидаемый вывод
        assertEquals(expectedOutput, outContent.toString());
    }
}