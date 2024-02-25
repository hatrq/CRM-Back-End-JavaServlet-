package main.service;

import main.entity.User;
import main.repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public boolean addUser(String fullName, String email, String password, String phoneNumber, int idRole){
        return userRepository.addUser(fullName, email, password, phoneNumber, idRole) > 0;
    }

    public List<User> showUser(){
        return userRepository.showUser();
    }

    public boolean deleteUserById(int id){
        return userRepository.deleteUserById(id) > 0;
    }

    public boolean updateUserById(int id, String email, String password, String firstName, String lastName, String userName, String phone, int idRole){
        return userRepository.upDateUserById(id, email, password, firstName, lastName, userName, phone, idRole) > 0;
    }
}
