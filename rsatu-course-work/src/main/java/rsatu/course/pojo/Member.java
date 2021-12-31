package rsatu.course.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import rsatu.course.utils.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Сущность Пользователь
 */
@Entity
@Table(name = "member")
public class Member {

    //    Уникальный идентификатор пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    Дата рождения
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column
    private Date birthDate;

    //    Пол
    @Column
    private String sex;

    //    ФИО
    @Column
    private String fio;

    //    Роль
    @Column
    private Role role;

    //  Список соревнований пользользователя
    @ManyToMany(mappedBy = "members")
    private List<Competition> competitions = new ArrayList<>();

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
