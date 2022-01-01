package rsatu.course.service;

import rsatu.course.pojo.Lake;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LakeService {

    @Inject
    EntityManager entityManager;

    // Вставка озера
    @Transactional
    public Lake insertLake(Lake lake) {
        entityManager.persist(lake);
        entityManager.flush();
        return lake;
    }

    //  Обновить озеро
    @Transactional
    public Lake updateLake(Lake lake) {
        entityManager.merge(lake);
        entityManager.flush();
        return lake;
    }

    //  Получить все озера
    public List<Lake> getAllLakes() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lake> cq = cb.createQuery(Lake.class);
        Root<Lake> rootEntry = cq.from(Lake.class);
        CriteriaQuery<Lake> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    //  Получить озеро по id
    public Lake getLakeById(String id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lake> cq = cb.createQuery(Lake.class);
        Root<Lake> rootEntry = cq.from(Lake.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
