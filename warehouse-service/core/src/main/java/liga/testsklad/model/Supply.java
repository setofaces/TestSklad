package liga.testsklad.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Supply {

    private Long id;

    private String positionName;

    private Long amount;

    private LocalDate arrivalDate;

    private LocalDate expirationDate;

}
