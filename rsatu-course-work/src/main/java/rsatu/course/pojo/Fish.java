package rsatu.course.pojo;

import javax.persistence.*;

/**
 * Сущность Рыба
 */
@Entity
@Table(name = "fish")
public class Fish {
    //    Уникальный идентификатор рыбы
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    Название семейства рыб
    @Column
    private String kind;

    //    Название рыбы
    @Column
    private String name;

    //    Средняя глубина обитания рыбы в озере
    @Column
    private Double depth;

    //    Средний вес рыбы
    @Column
    private Double weight;

    public Long getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
