package selfExecutableWebApp.demo.disease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import selfExecutableWebApp.demo.disease.dao.Medicine;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    @Query("select distinct d from Medicine d inner join d.doses r where d.description=?1 and ?2 between r.lowerParameterBound and r.upperParameterBound and r.parameterType=?3")
    List<Medicine> findByDescriptionAndParameter(String description, Integer paramValue, String paramType);  //TODO: czy te distinct nie lepiej rozwiązać jakoś inaczej w programie?

    @Transactional
    @Query("select d from Medicine d where d.name=?1")
    Medicine findByName(String name);
}
