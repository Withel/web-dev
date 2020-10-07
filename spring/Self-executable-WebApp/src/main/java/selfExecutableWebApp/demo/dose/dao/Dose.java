package selfExecutableWebApp.demo.dose.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import selfExecutableWebApp.demo.dose.dto.AddDoseDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Dose {

    @Id
    @GeneratedValue
    private Long dbId;
    private int lowerParameterBound;
    private int upperParameterBound;
    private double singleDose;
    private int dailyFrequency;
    private String parameterType;   // lata, miesiace itd - dotyczy pacjenta
    private String doseType; // ml, tabletki itd

    public Dose(AddDoseDTO dto){
        lowerParameterBound= dto.getLowerParameterBound();
        upperParameterBound=dto.getUpperParameterBound();
        singleDose=dto.getSingleDose();
        dailyFrequency=dto.getDailyFrequency();
        parameterType=dto.getParameterType();
        doseType=dto.getDoseType();
    }
}
