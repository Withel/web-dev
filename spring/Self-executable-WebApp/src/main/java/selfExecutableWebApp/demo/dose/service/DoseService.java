package selfExecutableWebApp.demo.dose.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import selfExecutableWebApp.demo.dose.dao.Dose;
import selfExecutableWebApp.demo.dose.dto.AddDoseDTO;
import selfExecutableWebApp.demo.dose.repository.DoseRepository;

@Service
@AllArgsConstructor
public class DoseService {

    private DoseRepository doseRepository;

    public Dose addDose(AddDoseDTO addDoseDTO) {
        Dose dose = new Dose(addDoseDTO);
        doseRepository.save(dose);
        return dose;
    }
}
