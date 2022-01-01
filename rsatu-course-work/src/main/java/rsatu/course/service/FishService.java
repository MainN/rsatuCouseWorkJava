package rsatu.course.service;

import rsatu.course.pojo.Fish;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FishService {

    @Inject
    EntityManager entityManager;

    // Вставка рыбы
    @Transactional
    public Fish insertFish(Fish fish) {
        entityManager.persist(fish);
        entityManager.flush();
        return fish;
    }

    //  Обновить рыбу
    @Transactional
    public Fish updateFish(Fish fish) {
        entityManager.merge(fish);
        entityManager.flush();
        return fish;
    }

    //  Получить все рыбы
    public List<Fish> getAllFishes() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fish> cq = cb.createQuery(Fish.class);
        Root<Fish> rootEntry = cq.from(Fish.class);
        CriteriaQuery<Fish> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    //  Получить рыбу по id
    public Fish getFishById(String id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fish> cq = cb.createQuery(Fish.class);
        Root<Fish> rootEntry = cq.from(Fish.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
