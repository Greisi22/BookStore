package Mock.Users;



import com.example.Model.Userss.UserService;
import com.example.Model.Userss.Users;

import java.util.ArrayList;

public class UserServiceMock extends UserService {

    private ArrayList<Users> users;
    public String path;
    @Override
    public   ArrayList<Users> getUsers(String path) {

        return (ArrayList<Users>) users;
    }

    @Override
    public  void writeUsersInFile(ArrayList<Users> newUser, String path) {

    }

    public void setUsers(ArrayList<Users> user)
    {
        this.users=user;
    }


}