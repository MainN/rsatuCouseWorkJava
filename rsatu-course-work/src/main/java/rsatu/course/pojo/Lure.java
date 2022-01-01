package rsatu.course.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность Наживка
 */
@Entity
@Table(name = "lure")
public class Lure {

    //Идентификатор наживки
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Название наживки
    @Column
    private String name;

    //Глубина действия наживки
    @Column
    private Double depth;

    //  Список соревнований, где используется наживка
    @ManyToMany(mappedBy = "lures")
    private List<Competition> competitions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
