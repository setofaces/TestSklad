package liga.testsklad.service.impl;

import liga.testsklad.dto.SupplyDto;
import liga.testsklad.mapper.MapStructMapper;
import liga.testsklad.repository.PositionRepository;
import liga.testsklad.repository.SupplyRepository;
import liga.testsklad.service.SupplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    private final MapStructMapper mapper;

    private final SupplyRepository supplyRepository;

    private final PositionRepository positionRepository;

    public SupplyServiceImpl(MapStructMapper mapper, SupplyRepository supplyRepository,
                             PositionRepository positionRepository) {
        this.mapper = mapper;
        this.supplyRepository = supplyRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void add(SupplyDto supplyDto) {
        supplyRepository.add(mapper.supplyDtoToSupply(supplyDto));
        positionRepository.increaseAmountByName(supplyDto.getPositionName(), supplyDto.getAmount());
    }

    @Override
    public List<SupplyDto> getAll() {
        return mapper.suppliesToSupplyDtos(supplyRepository.findAll());
    }

    @Override
    public SupplyDto findById(Long id) {
        return mapper.supplyToSupplyDto(supplyRepository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        supplyRepository.deleteById(id);
    }
}
