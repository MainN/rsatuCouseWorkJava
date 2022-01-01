package rsatu.course.service;

import rsatu.course.pojo.Lure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LureService {

    @Inject
    EntityManager entityManager;

    // Вставка наживки
    @Transactional
    public Lure insertLure(Lure lure) {
        entityManager.persist(lure);
        entityManager.flush();
        return lure;
    }

    //  Обновить наживку
    @Transactional
    public Lure updateLure(Lure lure) {
        entityManager.merge(lure);
        entityManager.flush();
        return lure;
    }

    //  Получить все наживки
    public List<Lure> getAllLures() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lure> cq = cb.createQuery(Lure.class);
        Root<Lure> rootEntry = cq.from(Lure.class);
        CriteriaQuery<Lure> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    //  Получить наживку по id
    public Lure getLureById(String id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lure> cq = cb.createQuery(Lure.class);
        Root<Lure> rootEntry = cq.from(Lure.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
