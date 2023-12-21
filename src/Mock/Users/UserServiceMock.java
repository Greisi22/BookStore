package Mock.Users;

import Model.Books.Zh_Books;
import Model.Users.D_Users;
import Model.Users.UserService;
import View.Administator.Users;

import java.util.ArrayList;

public class UserServiceMock extends UserService {

    private ArrayList<D_Users> users;
    public String path;
    @Override
    public   ArrayList<D_Users> getUsers(String path) {

        return (ArrayList<D_Users>) users;
    }

    @Override
    public  void writeUsersInFile(ArrayList<D_Users> newUser, String path) {

    }

    public void setUsers(ArrayList<D_Users> user)
    {
        this.users=user;
    }


}