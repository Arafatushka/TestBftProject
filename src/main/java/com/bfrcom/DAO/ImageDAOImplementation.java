package com.bfrcom.DAO;

import com.bfrcom.model.Image;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Repository
@Transactional
public class ImageDAOImplementation implements ImageDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public Image findById(Integer id) {
        TypedQuery<Image> query = em.createQuery(
                "select c from Image c where c.id=:id", Image.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Image> findAll() {
        return em.createQuery("select с from Image с",
                Image.class).getResultList();
    }

    @Override
    public void insert(Image image) {
        em.persist(image);
    }

    @Override
    public Image update(Image image) {
        if (image.getId() != 0 && em.find(Image.class, image.getId()) != null)
            em.merge(image);
        return image;
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Image.class, id));
    }
}
