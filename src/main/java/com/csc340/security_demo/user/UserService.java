package com.csc340.security_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Year;
import java.util.Calendar;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

     @Autowired
     PasswordEncoder passwordEncoder;

    /**
     * Get all users
     *
     * @return the list of users.
     */
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * Find one user by ID.
     *
     * @param id
     * @return the user
     */
    public User getUser(long id) {
        return repo.getReferenceById(id);
    }

    /**
     * Delete user by ID.
     *
     * @param id
     */
    public void deleteUser(long id) {
        repo.deleteById(id);
    }

    /**
     * Save user entry.
     *
     * @param user
     */
    public void saveUser(User user) {
        Calendar calendar = Calendar.getInstance();
        user.setCreatedAt(new Date(System.currentTimeMillis()));
        user.setUpdatedAt(new Date(System.currentTimeMillis()));
        user.setAccountStatus("active");
         user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    /**
     * Update existing user.
     *
     * @param user
     */
    public void updateUser(User user) {
        user.setUpdatedAt(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public User getUserByUserName(String userName) {
        return repo.findByUserName(userName).orElseThrow(()
                -> new UsernameNotFoundException(userName + "not found"));
    }
}
