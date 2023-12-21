package Test.UnitTest.Users;

import Mock.Books.BooksSreviceMock;
import Mock.Users.UserServiceMock;
import Model.Books.BookFunctionalities;
import Model.Books.Zh_Books;
import Model.Users.D_Users;
import Model.Users.UserFunctionalities;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFunctionalitiesTest {


    @Test
    public void testUpdateUser() {
        ArrayList<D_Users> usersListt = new ArrayList<>();
        D_Users user1 = new D_Users();
        D_Users user2 = new D_Users();

        user1.setEmail("greisijaho@gmail.com");
        user1.setFirstName("Greisi");

        user2.setEmail("DavidKeci@gmail.com");
        user2.setFirstName("David");


        usersListt.add(user1);
        usersListt.add(user2);

        UserFunctionalities coverConstuctor = new UserFunctionalities();

        UserServiceMock userServiceMock = new UserServiceMock();
        userServiceMock.setUsers(usersListt);

        UserFunctionalities userFunctionalities = new UserFunctionalities(userServiceMock);

        D_Users user = new D_Users();
        user.setEmail("greisijaho@gmail.com");
        user.setFirstName("Greisi2");

        ArrayList<D_Users> updatedUser =   UserFunctionalities.updateUsers(user);
        assertEquals(updatedUser.get(0).getFirstName(),user.getFirstName() );
    }


}