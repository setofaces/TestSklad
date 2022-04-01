package liga.testsklad.service;

import liga.testsklad.dto.SupplyDto;

import java.util.List;

public interface SupplyService {

    void add(SupplyDto supplyDto);

    List<SupplyDto> getAll();

    SupplyDto findById(Long id);

    void deleteById(Long id);
}
