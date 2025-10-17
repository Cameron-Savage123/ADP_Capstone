package za.ac.cput.service;

/*  UserService.java
    User Service class
    Author: Hope - 221174109
    Date: 25 May 2025
 */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    private static IUserService service;
    private UserRepository repository;

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }
}
