package selfExecutableWebApp.demo.dose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selfExecutableWebApp.demo.dose.dao.Dose;


public interface DoseRepository extends JpaRepository<Dose, Long> {

}
