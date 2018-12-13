package com.TreinametoCrud.CriandoProjetoCRUD.service.Impl;

import com.TreinametoCrud.CriandoProjetoCRUD.model.User;
import com.TreinametoCrud.CriandoProjetoCRUD.repositories.UserRepository;
import com.TreinametoCrud.CriandoProjetoCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user){
        saveUser(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

}
