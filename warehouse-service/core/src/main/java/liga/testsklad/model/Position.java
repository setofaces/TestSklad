package liga.testsklad.model;

import lombok.Data;

@Data
public class Position {

    private Long id;

    private String name;

    private Long price;

    private Long amount;

    private Long categoryId;
}
