package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserService {
    User create(User user);

    User read(String id);

    User update(User user);

    boolean delete(String id);

    List<User> getAll();
}
