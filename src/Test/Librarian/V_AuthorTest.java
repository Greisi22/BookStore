package Test.Librarian;

import Librarian.V_Author;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Librarian.Gender;

class V_AuthorTest {

    @Test
    void getFirstName() {
        V_Author author = new V_Author("Greisi");
        assertEquals("Greisi", author.getFirstName());
        assertNotNull(author.getFirstName());
    }

    @Test
    void setFirstName() {
        V_Author author = new V_Author("Greisi");
        author.setFirstName("Greisi");
        assertEquals("Greisi", author.getFirstName());
    }

    @Test
    void getLastName() {
        V_Author author = new V_Author("Greisi", "Jaho", Gender.Female);
        assertEquals("Jaho", author.getLastName());
        assertNotNull( author.getLastName());
    }

    @Test
    void setLastName() {
        V_Author author = new V_Author("Greisi", "Jaho", Gender.Female);
        author.setLastName("Jaho");
        assertEquals("Jaho", author.getLastName());
    }

    @Test
    void getGender() {
        V_Author author = new V_Author("Greisi", "Jaho", Gender.Female);
        assertEquals(Gender.Female, author.getGender());
        assertNotNull( author.getGender());
    }

    @Test
    void setGender() {
        V_Author author = new V_Author("Greisi", "Jaho", Gender.Female);
        author.setGender(Gender.Female);
        assertEquals(Gender.Female, author.getGender());
    }


}