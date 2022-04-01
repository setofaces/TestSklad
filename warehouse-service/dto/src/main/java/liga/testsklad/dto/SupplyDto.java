package liga.testsklad.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SupplyDto {

    private String positionName;

    private Long amount;

    private LocalDate arrivalDate;

    private LocalDate expirationDate;
}
