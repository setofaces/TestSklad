package liga.testsklad.service;

import liga.testsklad.dto.PositionDto;

import java.util.List;

public interface PositionService {

    void add(PositionDto positionDto);

    List<PositionDto> getAll();

    Boolean sell(PositionDto positionDto, Long amount);

    PositionDto findById(Long id);

    PositionDto findByName(String name);

    void updateById(Long id, PositionDto positionDto);

    void deleteById(Long id);
}
