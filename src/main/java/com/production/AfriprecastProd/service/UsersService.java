package com.production.AfriprecastProd.service;

import com.production.AfriprecastProd.model.Users;
import com.production.AfriprecastProd.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(String login, String password, String email){
        if (login == null || password == null) {
            return null;
        } else {
            Users users = new Users();
            users.setLogin(login);
            users.setPassword(password);
            users.setEmail(email);
            return usersRepository.save(users);
        }
    }

    public Users authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
