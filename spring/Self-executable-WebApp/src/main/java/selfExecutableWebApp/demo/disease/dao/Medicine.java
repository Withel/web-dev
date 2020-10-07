package selfExecutableWebApp.demo.disease.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import selfExecutableWebApp.demo.disease.dto.AddMedicineDTO;
import selfExecutableWebApp.demo.dose.dao.Dose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue
    private Long dbId;

    @Column(unique = true)
    private String name;
    private String description;
    private String activeSubstance;

    @OneToMany
    private List<Dose> doses;

    public Medicine(AddMedicineDTO dto) {
        name = dto.getName();
        description = dto.getDescription();
        activeSubstance = dto.getActiveSubstance();
        doses = new ArrayList<>();
    }

    public void addDose(Dose dose) {
        this.doses.add(dose);
    }


}
