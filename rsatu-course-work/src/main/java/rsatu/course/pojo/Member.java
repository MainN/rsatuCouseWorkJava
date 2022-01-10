package rsatu.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import rsatu.course.enums.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Сущность Пользователь
 */
@Entity
@Table(name = "member")
public class Member extends PanacheEntity {
    //    Дата рождения
    public Date birthDate;
    //    Пол
    public String sex;
    //    ФИО
    public String fio;
    //    Роль
    public Role role;
    // email
    public String email;

    //  Список соревнований пользользователя
    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    private Collection<Competition> competitions;

    public Member() {
    }

    public static List<Member> findAllMembers(){
        return listAll();
    }

    public static Member findMemberById(Long id){
        return findById(id);
    }

    public static List<Member> findMembersByIdComp(Long id) {
        Competition competition = Competition.findCompetitionById(id);
        if (competition != null) {
            return (List<Member>) competition.members;
        }
        return null;
    }

    public static Member findByEmail(String email) {
        return Member.find("email", email).firstResult();
    }
}
