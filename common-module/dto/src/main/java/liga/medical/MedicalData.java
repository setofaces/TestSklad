package liga.medical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicalData implements Serializable {

    private Double temperature;

    private Double pressure;

    private Double glucoseLevel;

    private Integer pulse;
}
