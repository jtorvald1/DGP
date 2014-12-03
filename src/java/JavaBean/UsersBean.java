/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaBean;

import java.util.ArrayList;

public class UsersBean {
    
    private ArrayList<UserBean> allUsers = new ArrayList<UserBean>();

    public UsersBean() {
    }

    public ArrayList<UserBean> getUsers() {
        return allUsers;
    }

    public void setUsers(ArrayList<UserBean> allUsers) {
        this.allUsers = allUsers;
    }

    @Override
    public String toString() {
        return "UsersBean{" + "allUsers=" + allUsers + '}';
    }
}
