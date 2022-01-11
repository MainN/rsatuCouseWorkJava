package rsatu.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.File;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Сущность Информация о файле с итогами соревнования
 */
@Entity
@Table(name = "fileinfo")
public class FileInfo extends PanacheEntity {
    //имя файла
    public String name;
    //дата загрузки
    public LocalDate uploadDate;

    // список соревнований, проходящих на озере
    @OneToOne(mappedBy = "fileInfo")
    @JsonIgnore
    public Competition competition;

    public static FileInfo findFileInfoByIdComp(Long id) {
        return (FileInfo) find("idCompetition", id).firstResult();
    }
}