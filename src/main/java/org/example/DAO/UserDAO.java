package org.example.DAO;

import io.dropwizard.hibernate.AbstractDAO;
import org.example.Entity.User;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User getUser(String id){
        return get(id);
    }

    public User addUser(User user){
        return persist(user);
    }

    public List<User> getUsers(){
        return list(currentSession().createQuery("SELECT p FROM User p"));
    }

    public void deleteUser(String id){
        User user = getUser(id);
        currentSession().delete(user);
    }

    public User updateUser(User user){
        String userId = user.getId();
        currentSession().update(user);
        return this.getUser(userId);
    }
}