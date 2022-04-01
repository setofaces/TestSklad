package liga.testsklad.dto;

import lombok.Data;

@Data
public class PositionDto {

    private String name;

    private Long price;

    private Long amount;

    private Long categoryId;
}
