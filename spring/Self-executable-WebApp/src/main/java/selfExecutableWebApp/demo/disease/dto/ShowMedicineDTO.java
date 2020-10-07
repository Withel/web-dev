package selfExecutableWebApp.demo.disease.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import selfExecutableWebApp.demo.disease.dao.Medicine;
import selfExecutableWebApp.demo.dose.dto.AddDoseDTO;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShowMedicineDTO {

    private String name;
    private String activeSubstance;
    private List<AddDoseDTO> doses;


    public ShowMedicineDTO(List<AddDoseDTO> doses, Medicine medicine){
        this.name=medicine.getName();
        this.activeSubstance=medicine.getActiveSubstance();
        this.doses= new LinkedList<>(doses);
    }
}
