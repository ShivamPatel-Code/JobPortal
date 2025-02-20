package com.projects.jobportal.services;

import com.projects.jobportal.entity.Users;
import com.projects.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        usersRepository.save(users);
    }

    public Optional<Users> getUsersByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}
