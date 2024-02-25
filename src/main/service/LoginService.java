package main.service;

import main.repository.LoginRepository;

public class LoginService {
    private LoginRepository loginRepository = new LoginRepository();

    public boolean login(String email, String password){
        return loginRepository.login(email, password) > 0;
    }
}
