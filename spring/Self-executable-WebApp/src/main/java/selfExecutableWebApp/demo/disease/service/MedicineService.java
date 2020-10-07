package selfExecutableWebApp.demo.disease.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import selfExecutableWebApp.demo.disease.dao.Medicine;
import selfExecutableWebApp.demo.disease.dto.AddMedicineDTO;
import selfExecutableWebApp.demo.disease.dto.MedicineDTO;
import selfExecutableWebApp.demo.disease.dto.ShowMedicineDTO;
import selfExecutableWebApp.demo.disease.repository.MedicineRepository;
import selfExecutableWebApp.demo.dose.dao.Dose;
import selfExecutableWebApp.demo.dose.dto.AddDoseDTO;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicineService {

    private MedicineRepository medicineRepository;

    public List<ShowMedicineDTO> findMedicine(MedicineDTO medicineDTO) {
        List<Medicine> result = medicineRepository.findByDescriptionAndParameter(medicineDTO.getDescription(), medicineDTO.getSearchParamValue(), medicineDTO.getSearchParamType());
        List<ShowMedicineDTO> resultDTO = new LinkedList<>();
        List<AddDoseDTO> doseDTOS = new LinkedList<>();
        for (Medicine medicine : result) {
            for (Dose dose : medicine.getDoses()) {
                if (dose.getUpperParameterBound() >= medicineDTO.getSearchParamValue() && dose.getLowerParameterBound() <= medicineDTO.getSearchParamValue()) {
                    doseDTOS.add(new AddDoseDTO(dose));
                }
            }
            resultDTO.add(new ShowMedicineDTO(doseDTOS,medicine));
            doseDTOS.clear();
        }
        return resultDTO;
    }

    public String addMedicine(AddMedicineDTO addMedicineDTO) {
        Medicine disease = new Medicine(addMedicineDTO);
        medicineRepository.save(disease);
        return disease.getName();
    }

    public void saveChanges(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public Medicine findMedicineByName(String name) {
        return medicineRepository.findByName(name);
    }

    public List<ShowMedicineDTO> getAllDiseases() {
       List<Medicine> repoResult = medicineRepository.findAll();
       List<ShowMedicineDTO> toShowResult =new LinkedList<>();
       List<AddDoseDTO> doseDTOS = new LinkedList<>();
        for(Medicine medicine:repoResult){
            for(Dose dose:medicine.getDoses()){
                doseDTOS.add(new AddDoseDTO(dose));
            }
            toShowResult.add(new ShowMedicineDTO(doseDTOS,medicine));
            doseDTOS.clear();
        }
        return toShowResult;
    }
}
