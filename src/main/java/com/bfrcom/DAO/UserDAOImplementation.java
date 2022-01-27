package com.bfrcom.DAO;

import com.bfrcom.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Repository
@Transactional
public class UserDAOImplementation implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User findByName(@PathVariable String name) {
        TypedQuery<User> query = em.createQuery(
                "select u from User u where u.name=:name", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @ResponseBody
    public List<User> findAll() {
        return em.createQuery("select с from User с",
                User.class).getResultList();
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void insert(User user) {
        em.persist(user);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(User user) {
        if (user.getId() != 0 && em.find(User.class, user.getId()) != null)
            em.merge(user);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void delete(String name) {
        em.remove(findByName(name));
    }
}
