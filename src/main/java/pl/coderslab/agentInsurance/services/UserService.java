package pl.coderslab.agentInsurance.services;

import pl.coderslab.agentInsurance.model.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}