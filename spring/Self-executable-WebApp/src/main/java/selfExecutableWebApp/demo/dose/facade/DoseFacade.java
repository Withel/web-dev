package selfExecutableWebApp.demo.dose.facade;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import selfExecutableWebApp.demo.dose.dao.Dose;
import selfExecutableWebApp.demo.dose.dto.AddDoseDTO;
import selfExecutableWebApp.demo.dose.service.DoseService;

@Component
@AllArgsConstructor
public class DoseFacade {

    private DoseService doseService;

    public Dose addDose(AddDoseDTO addDoseDTO) {
        return doseService.addDose(addDoseDTO);
    }

}
