package rsatu.course.pojo;

import javax.persistence.*;

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
}
