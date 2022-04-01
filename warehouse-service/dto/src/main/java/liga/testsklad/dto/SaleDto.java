package liga.testsklad.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SaleDto {

    private String positionName; //or Position??

    private LocalDate date;

    private Long amount;

    private Long moneySpent;
}
