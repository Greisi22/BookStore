package Test.UnitTest.Books;

import Model.Books.V_Author;
import Model.Users.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        author.setFirstName("Era");
        String actual = author.getFirstName();
        assertEquals("Era",actual );
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