package rsatu.course.service;

import rsatu.course.pojo.Member;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MemberService {

    @Inject
    EntityManager entityManager;

    // Вставка пользователя
    @Transactional
    public Member insertMember(Member member) {
        entityManager.persist(member);
        entityManager.flush();
        return member;
    }

    //  Обновить пользователя
    @Transactional
    public Member updateMember(Member member) {
        entityManager.merge(member);
        entityManager.flush();
        return member;
    }

    //  Получить всех пользователей
    public List<Member> getAllMembers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> rootEntry = cq.from(Member.class);
        CriteriaQuery<Member> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    //  Получить пользователя по id
    public Member getMemberById(String id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> rootEntry = cq.from(Member.class);
        cq.select(rootEntry).where(cb.equal(rootEntry.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
