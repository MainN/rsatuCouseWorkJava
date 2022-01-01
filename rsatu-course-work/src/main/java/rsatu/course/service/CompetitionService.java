package rsatu.course.service;

import rsatu.course.pojo.Competition;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CompetitionService {

    @Inject
    EntityManager entityManager;

    // Вставка соревнования
    @Transactional
    public Competition insertCompetition(Competition competition) {
        entityManager.persist(competition);
        entityManager.flush();
        return competition;
    }

    //  Обновить соревнование
    @Transactional
    public Competition updateCompetition(Competition competition) {
        entityManager.merge(competition);
        entityManager.flush();
        return competition;
    }

    //  Получить все соревнования
    public List<Competition> getAllCompetitions() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Competition> cq = cb.createQuery(Competition.class);
        Root<Competition> rootEntry = cq.from(Competition.class);
        CriteriaQuery<Competition> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    //  Получить соревнования по переданному атрибуту
    public List<Competition> getCompetitionsByAttr(String attrName, String attrValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Competition> cq = cb.createQuery(Competition.class);
        Root<Competition> rootEntry = cq.from(Competition.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get(attrName), attrValue));
        return entityManager.createQuery(cq).getResultList();
    }

    //  Получить соревнование по id
    public Competition getCompetitionById(String id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Competition> cq = cb.createQuery(Competition.class);
        Root<Competition> rootEntry = cq.from(Competition.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
