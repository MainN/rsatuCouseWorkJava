package rsatu.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Сущность Наживка
 */
@Entity
@Table(name = "lure")
public class Lure extends PanacheEntity {

    //Название наживки
    public String name;

    //Глубина действия наживки
    public Double depth;

    //  Список соревнований, где используется наживка
    @ManyToMany(mappedBy = "lures")
    @JsonIgnore
    public Collection<Competition> competition;

    public Lure() {
    }

    public static List<Lure> findAllLures(){
        return listAll();
    }

    public static List<Lure> findLureById(String id){
        return findById(id);
    }

    public static Lure insertLure(Lure lure) {
        lure.persist();
        return lure;
    }
}
