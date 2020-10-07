package selfExecutableWebApp.demo.disease.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import selfExecutableWebApp.demo.disease.dao.Medicine;
import selfExecutableWebApp.demo.disease.dto.AddMedicineDTO;
import selfExecutableWebApp.demo.disease.dto.MedicineDTO;
import selfExecutableWebApp.demo.disease.facade.MedicineFacade;
import selfExecutableWebApp.demo.dose.facade.DoseFacade;

import java.util.List;

@Controller
@RequestMapping("/disease")
@AllArgsConstructor
public class MedicineController {

    private MedicineFacade medicineFacade;
    private DoseFacade doseFacade;

    @GetMapping("/parametrize")
    String findMedicinePage(Model model) {
        model.addAttribute("infection", new MedicineDTO());
        return "disease/parametrize";
    }

    @PostMapping("/parametrize")
    String findMedicine(@ModelAttribute MedicineDTO medicineDTO, Model model) {
        model.addAttribute("medicines", medicineFacade.findMedicine(medicineDTO));
        model.addAttribute("searchParamValue", medicineDTO.getSearchParamValue());
        model.addAttribute("searchParamType", medicineDTO.getSearchParamType());
        return "disease/found";
    }

    @GetMapping("/createmed")
    String addMedPage(Model model) {
        model.addAttribute("addMed", new AddMedicineDTO());
        return "disease/createmed";
    }

    @PostMapping("/createmed")
    String addMed(@ModelAttribute AddMedicineDTO addMedicineDTO) {
        String medicineName = medicineFacade.addMedicine(addMedicineDTO);
        return "redirect:/dose/createdose/" + medicineName;
    }

    @GetMapping("/added")
    String addedPage(@ModelAttribute Medicine medicine) {
        return "disease/medcreated";
    }

    @GetMapping("/showall")
    String showAllMedsPage(Model model){
        model.addAttribute("medicines",medicineFacade.getAllMedicines());
        return "disease/found";
    }

    @GetMapping("/found")
    String showFoundPage(@ModelAttribute List<Medicine> medicines, @ModelAttribute String takitest, Model model) {
        model.addAttribute("founds", medicines);
        return "disease/found";
    }
}
