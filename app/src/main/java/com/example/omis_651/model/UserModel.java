package com.example.omis_651.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by vamse on 3/13/2019.
 */

@Table(name = "UserDetails")
public class UserModel extends Model {
    @Column(name = "user_name")
    public String userName;
    @Column(name = "user_pwd")
    public String password;
    @Column(name = "user_dept")
    public String department;

    public static boolean checkUserAvailable(String userName) {
        List<UserModel> users = new Select().from(UserModel.class).execute();
        for (int i = 0; i < users.size(); i++) {
            UserModel user = users.get(i);
            if (user.userName.equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public static UserModel getUserDetails(String userName) {
        List<UserModel> users = new Select().from(UserModel.class).execute();
        for (int i = 0; i < users.size(); i++) {
            UserModel user = users.get(i);
            if (user.userName.equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
