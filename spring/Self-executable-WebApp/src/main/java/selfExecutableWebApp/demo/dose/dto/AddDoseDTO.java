package selfExecutableWebApp.demo.dose.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import selfExecutableWebApp.demo.dose.dao.Dose;

@Getter
@Setter
@NoArgsConstructor
public class AddDoseDTO {

    private int lowerParameterBound;
    private int upperParameterBound;
    private double singleDose;
    private int dailyFrequency;
    private String parameterType;   // lata, miesiace itd - dotyczy pacjenta
    private String doseType; // ml, tabletki itd
    private String diseaseName;

    public AddDoseDTO(Dose dose) {
        lowerParameterBound=dose.getLowerParameterBound();
        upperParameterBound=dose.getUpperParameterBound();
        singleDose=dose.getSingleDose();
        dailyFrequency=dose.getDailyFrequency();
        parameterType=dose.getParameterType();
        doseType=dose.getDoseType();
        diseaseName=null; //TODO:REFACTOR
    }
}
