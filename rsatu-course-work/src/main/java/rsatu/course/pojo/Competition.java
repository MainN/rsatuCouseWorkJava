package rsatu.course.pojo;

import rsatu.course.utils.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Сущность Соревнование
 */
@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //  дата начала соревнования
    @Column
    private Date startDate;

    //  максимальное количество членов клуба, которое может принять участие в соревновании
    @Column
    private Integer maxMembers;

    //  вид соревнования
    @Column
    private Type type;

    //  вознаграждение за первое место
    @Column
    private String prize;

    //  победитель
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="winner_id")
    private Member winner;

    //  количество пойманных рыб
    @Column
    private Integer fishesNumber;

    //  признак завершения соревнования
    @Column
    private Boolean isCompleted;

    //  список участников соревнования
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "competition_member",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members = new ArrayList<>();

    //  список используемых наживок
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "competition_lure",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "lure_id")
    )
    private List<Member> lures = new ArrayList<>();

    //  озеро, где проходит соревнование
    @ManyToOne
    @JoinColumn(name = "lake_id")
    private Lake lake;

    // Дата завершения соревнования
    @Column
    private Date endDate;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Member getWinner() {
        return winner;
    }

    public void setWinner(Member winner) {
        this.winner = winner;
    }

    public Integer getFishesNumber() {
        return fishesNumber;
    }

    public void setFishesNumber(Integer fishesNumber) {
        this.fishesNumber = fishesNumber;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Member> getLures() {
        return lures;
    }

    public void setLures(List<Member> lures) {
        this.lures = lures;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        this.lake = lake;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
