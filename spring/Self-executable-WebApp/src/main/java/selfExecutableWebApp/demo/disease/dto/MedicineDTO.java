package selfExecutableWebApp.demo.disease.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class MedicineDTO {

    private String description;
    private Integer searchParamValue;
    private String searchParamType;
}
