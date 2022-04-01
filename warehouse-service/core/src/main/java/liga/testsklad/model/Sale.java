package liga.testsklad.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Sale {

    private Long id;

    private String positionName;

    private LocalDate date;

    private Long amount;

    private Long moneySpent;
}
