package com.bfrcom.DAO;

import com.bfrcom.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("BookDAOImplement")
@Repository
@Transactional
public class BookDAOHibernate implements BookDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Book findById(Long id) {
        TypedQuery<Book> query = em.createQuery(
                "select c from Book c where c.id=:id", Book.class);
        query.setParameter ( "id", id) ;
        return query.getSingleResult();
    }

    @Transactional(readOnly=true)
    public List<Book> findAll() {
        return em.createQuery("select с from Book с",
                Book.class).getResultList();
    }

   /* @Override
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public void update(Book book) {
        if (book.getId()!=0 && em.find(Book.class, book.getId())!=null)
            em.merge(book);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Book.class, id));
    }*/
}
