package rsatu.course.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lake")
public class Lake {
    //    Уникальный идентификатор озера
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    Площадь озера
    @Column
    private Double area;

    //    Глубина озера
    @Column
    private Double depth;

    //    Название озера
    @Column
    private String name;

    // список соревнований, проходящих на озере
    @OneToMany(mappedBy = "lake", cascade = CascadeType.ALL)
    private List<Competition> competitions = new ArrayList<>();

    //  список рыб которые обитают в озере
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "lake_fish",
            joinColumns = @JoinColumn(name = "lake_id"),
            inverseJoinColumns = @JoinColumn(name = "fish_id")
    )
    private List<Fish> fishes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public List<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(List<Fish> fishes) {
        this.fishes = fishes;
    }
}
