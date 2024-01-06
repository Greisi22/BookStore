package Test.UnitTest.Users;


import Mock.Users.UserServiceMock;
import com.example.Model.Userss.UserFunctionalities;
import com.example.Model.Userss.Users;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFunctionalitiesTest {


    @Test
    public void testUpdateUser() {
        ArrayList<Users> usersListt = new ArrayList<>();
        Users user1 = new Users();
        Users user2 = new Users();

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

        Users user = new Users();
        user.setEmail("greisijaho@gmail.com");
        user.setFirstName("Greisi2");

        ArrayList<Users> updatedUser =   UserFunctionalities.updateUsers(user);
        assertEquals(updatedUser.get(0).getFirstName(),user.getFirstName() );
    }


}