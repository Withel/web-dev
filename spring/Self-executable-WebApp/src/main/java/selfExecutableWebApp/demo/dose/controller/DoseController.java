package selfExecutableWebApp.demo.dose.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import selfExecutableWebApp.demo.disease.dao.Medicine;
import selfExecutableWebApp.demo.disease.facade.MedicineFacade;
import selfExecutableWebApp.demo.dose.dao.Dose;
import selfExecutableWebApp.demo.dose.dto.AddDoseDTO;
import selfExecutableWebApp.demo.dose.facade.DoseFacade;

@Controller
@AllArgsConstructor
@RequestMapping("/dose")
public class DoseController {
    private MedicineFacade medicineFacade;
    private DoseFacade doseFacade;

    @GetMapping("/createdose/{name}")
    String addDoseToNewMedPage(@PathVariable("name") String name, Model model) {
        AddDoseDTO addDoseDTO = new AddDoseDTO();
        addDoseDTO.setDiseaseName(name);
        model.addAttribute("dose", addDoseDTO);
        return "dose/createdose";
    }

    @PostMapping("/createdose")
    String addDoseToNewMed(@ModelAttribute AddDoseDTO dto) {
        Medicine medicine = medicineFacade.findMedicineByName(dto.getDiseaseName());
        Dose dose = doseFacade.addDose(dto);
        medicineFacade.addDose(medicine, dose);
        return "redirect:/dose/dosecreated";
    }

    @GetMapping("/dosecreated")
    String addedPage(@ModelAttribute Medicine medicine) {
        return "dose/dosecreated";
    }

    @GetMapping("/dosetoexisting")
    String addDosetToExistingPage(Model model) {
        model.addAttribute("meds", medicineFacade.getAllMedicines());
        return "dose/selectmed";
    }

    @PostMapping("/selectmedfordose")
    String addDosetToExisting(@RequestParam String sourceText) {
        return "redirect:/dose/createdose/" + sourceText;
    }


}
