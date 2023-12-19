package Test.Librarian;

import Model.Users.D_Users;
import Model.Bills.Zh_MyDate;
import Test.Librarian.Books.Zh_accessLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class D_UsersTest {
    @Test
    public void testD_UsersConstructorAndGetters() {
        // Creating a sample Zh_MyDate for the birthday
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);

        // Creating a D_Users object
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);

        assertEquals("Greisi", user.getFirstName());
        assertEquals("Jaho", user.getLastName());
        assertEquals("Gr_ja.@example.com", user.getEmail());
        assertEquals(birthday, user.getBirthday());
        assertEquals("password", user.getPassword());
        assertEquals(50000, user.getSalery());
        assertEquals("123-456-7890", user.getPhone());
        assertEquals(Zh_accessLevel.ADMINISTRATOR, user.getAccesLevel());
        System.out.println("A user can be created successfully");
    }
    @Test
    public void getFirstName() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        String firstName = user.getFirstName();
        assertTrue(firstName instanceof String);
        assertEquals("Greisi", user.getFirstName());
    }

    @Test
    void setFirstName() {
        D_Users user = new D_Users();
        user.setFirstName("Greisi");
        assertEquals("Greisi", user.getFirstName());
        String firstName = user.getFirstName();
        assertTrue(firstName instanceof String);
        assertEquals("Greisi", user.getFirstName());
        assertNotNull(user.getFirstName());
    }



    @Test
    void getEmail() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        String email = user.getEmail();
        assertTrue(email instanceof String);
        assertEquals("Gr_ja.@example.com", user.getEmail());
        assertNotNull(user.getEmail());
    }

    @Test
    void setEmail() {
        D_Users user = new D_Users();
        user.setEmail("Gr_ja.@example.com");
        assertEquals("Gr_ja.@example.com", user.getEmail());
        String email = user.getEmail();
        assertTrue(email instanceof String);
        assertEquals("Gr_ja.@example.com", user.getEmail());
        assertNotNull(user.getEmail());
    }


    @Test
    void getPassword() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        String password = user.getPassword();
        assertTrue(password instanceof String);
        assertEquals("password", user.getPassword());
        assertNotNull(user.getPassword());
    }

    @Test
    void setPassword() {
        D_Users user = new D_Users();
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
        String password = user.getPassword();
        assertTrue(password instanceof String);
        assertEquals("newPassword", user.getPassword());
        assertNotNull(user.getPassword());
    }


    @Test
    void getSalary() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        long salary = user.getSalery();
        assertEquals(50000, salary);
        assertNotNull(user.getSalery());
    }

    @Test
    void setSalary() {
        D_Users user = new D_Users();
        user.setSalery(60000);
        assertEquals(60000, user.getSalery());
        long salary = user.getSalery();
        assertEquals(60000, salary);
    }


    @Test
    void getAccessLevel() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        Zh_accessLevel accessLevel = user.getAccesLevel();
        assertEquals(Zh_accessLevel.ADMINISTRATOR, accessLevel);
        assertNotNull(user.getAccesLevel());
    }

    @Test
    void setAccessLevel() {
        D_Users user = new D_Users();
        user.setAccesLevel(Zh_accessLevel.ADMINISTRATOR);
        assertEquals(Zh_accessLevel.ADMINISTRATOR, user.getAccesLevel());
        Zh_accessLevel accessLevel = user.getAccesLevel();
        assertEquals(Zh_accessLevel.ADMINISTRATOR, accessLevel);
    }

    @Test
    void getLastName() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        String lastName = user.getLastName();
        assertTrue(lastName instanceof String);
        assertEquals("Jaho", lastName);
        assertNotNull(user.getLastName());
    }

    @Test
    void setLastName() {
        D_Users user = new D_Users();
        user.setLastName("Smith");
        assertEquals("Smith", user.getLastName());
        String lastName = user.getLastName();
        assertTrue(lastName instanceof String);
        assertEquals("Smith", lastName);
    }

    @Test
    void getPhone() {
        Zh_MyDate birthday = new Zh_MyDate(2002, 13, 11);
        D_Users user = new D_Users("Greisi", "Jaho",
                "Gr_ja.@example.com", birthday, "password",
                50000, "123-456-7890", Zh_accessLevel.ADMINISTRATOR);
        String phone = user.getPhone();
        assertTrue(phone instanceof String);
        assertEquals("123-456-7890", phone);
        assertNotNull(user.getPhone());
    }

    @Test
    void setPhone() {
        D_Users user = new D_Users();
        user.setPhone("987-654-3210");
        assertEquals("987-654-3210", user.getPhone());
        String phone = user.getPhone();
        assertTrue(phone instanceof String);
        assertEquals("987-654-3210", phone);
    }



}