package rsatu.course.pojo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;
import java.time.LocalDate;

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
    //идентификатор соревнования, для которого создавался отчет
    public Long idCompetition;

    public static FileInfo findFileInfoByIdComp(Long id) {
        return (FileInfo) find("idCompetition", id).firstResult();
    }
}