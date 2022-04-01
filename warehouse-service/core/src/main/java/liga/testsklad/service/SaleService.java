package liga.testsklad.service;

import liga.testsklad.dto.SaleDto;

import java.util.List;

public interface SaleService {

    List<SaleDto> findAll();

    SaleDto findById(Long id);

    boolean sell(String name, Long amount);

    void deleteById(Long id);

}
