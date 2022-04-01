package liga.testsklad.service.impl;

import liga.testsklad.dto.PositionDto;
import liga.testsklad.mapper.MapStructMapper;
import liga.testsklad.repository.PositionRepository;
import liga.testsklad.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final MapStructMapper mapper;

    private final PositionRepository positionRepository;

    public PositionServiceImpl(MapStructMapper mapper, PositionRepository positionRepository) {
        this.mapper = mapper;
        this.positionRepository = positionRepository;
    }

    @Override
    public void add(PositionDto positionDto) {
        positionRepository.add(mapper.positionDtoToPosition(positionDto));
    }

    @Override
    public List<PositionDto> getAll() {
        return mapper.positionsToPositionDtos(positionRepository.findAll());
    }

    @Override
    public Boolean sell(PositionDto positionDto, Long amount) {
        return null;
    }

    @Override
    public PositionDto findById(Long id) {
        return mapper.positionToPositionDto(positionRepository.findById(id));
    }

    @Override
    public PositionDto findByName(String name) {
        return mapper.positionToPositionDto(positionRepository.findByName(name));
    }

    @Override
    public void updateById(Long id, PositionDto positionDto) {
        positionRepository.updateById(id, mapper.positionDtoToPosition(positionDto));
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.deleteById(id);
    }
}
