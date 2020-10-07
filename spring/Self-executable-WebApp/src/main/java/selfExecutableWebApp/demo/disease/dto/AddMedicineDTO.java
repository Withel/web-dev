package selfExecutableWebApp.demo.disease.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddMedicineDTO {
    private String name;
    private String description;
    private String activeSubstance;
}
