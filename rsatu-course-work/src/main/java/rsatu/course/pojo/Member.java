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

    //  Список соревнований пользользователя
    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    private Collection<Competition> competitions;

    public Member() {
    }

    public static List<Member> findAllMembers(){
        return listAll();
    }

    public static List<Member> findMemberById(String id){
        return findById(id);
    }
}
