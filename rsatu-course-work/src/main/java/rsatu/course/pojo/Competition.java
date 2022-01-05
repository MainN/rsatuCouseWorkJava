package rsatu.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import rsatu.course.enums.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Сущность Соревнование
 */
@Entity
@Table(name = "competition")
public class Competition extends PanacheEntity {

    //  дата начала соревнования
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    public Date startDate;

    //  максимальное количество членов клуба, которое может принять участие в соревновании
    public Integer maxMembers;

    //  вид соревнования
    public Type type;

    //  вознаграждение за первое место
    public Double prize;

    //  количество пойманных рыб
    public Integer fishesNumber;

    //  признак завершения соревнования
    public Boolean isCompleted;

    // Дата завершения соревнования
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    public Date endDate;

    //  список участников соревнования
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "competition_member",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    public Collection<Member> members;

    //  список используемых наживок
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "competition_lure",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "lure_id")
    )
    public Collection<Lure> lures;

    //  озеро, где проходит соревнование
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lake_id")
    @JsonIgnore
    public Lake lake;

    public static List<Competition> findAllCompetitions(){
        return listAll();
    }

    public static List<Competition> findCompetitionById(String id){
        return findById(id);
    }

    public static Competition insertCompetition(Competition competition) {
        competition.persist();
        return competition;
    }

    public Competition() {
    }
}