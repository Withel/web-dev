package selfExecutableWebApp.demo.disease.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import selfExecutableWebApp.demo.disease.dao.Medicine;
import selfExecutableWebApp.demo.disease.dto.AddMedicineDTO;
import selfExecutableWebApp.demo.disease.dto.MedicineDTO;
import selfExecutableWebApp.demo.disease.dto.ShowMedicineDTO;
import selfExecutableWebApp.demo.disease.service.MedicineService;
import selfExecutableWebApp.demo.dose.dao.Dose;

import java.util.List;

@Component
@AllArgsConstructor
public class MedicineFacade {

    private MedicineService medicineService;

    public List<ShowMedicineDTO> findMedicine(MedicineDTO medicineDTO) {
        return medicineService.findMedicine(medicineDTO);
    }

    public List<ShowMedicineDTO> getAllMedicines(){
        return  medicineService.getAllDiseases();
    }

    public String addMedicine(AddMedicineDTO addMedicineDTO) {
        return medicineService.addMedicine(addMedicineDTO);
    }

    public void addDose(Medicine medicine, Dose dose) {
        medicine.addDose(dose);
        medicineService.saveChanges(medicine);
    }

    public Medicine findMedicineByName(String name) {
        return medicineService.findMedicineByName(name);
    }
}
