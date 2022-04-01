package liga.testsklad.service.impl;

import liga.testsklad.dto.SaleDto;
import liga.testsklad.mapper.MapStructMapper;
import liga.testsklad.model.Position;
import liga.testsklad.model.Supply;
import liga.testsklad.repository.PositionRepository;
import liga.testsklad.repository.SaleRepository;
import liga.testsklad.repository.SupplyRepository;
import liga.testsklad.service.SaleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class SaleServiceImpl implements SaleService {

    private final MapStructMapper mapper;

    private final SaleRepository saleRepository;

    private final PositionRepository positionRepository;

    private final SupplyRepository supplyRepository;

    public SaleServiceImpl(MapStructMapper mapper, SaleRepository saleRepository,
                           PositionRepository positionRepository, SupplyRepository supplyRepository) {
        this.mapper = mapper;
        this.saleRepository = saleRepository;
        this.positionRepository = positionRepository;
        this.supplyRepository = supplyRepository;
    }

    public boolean sell(String positionName, Long amount) {

        Position position = positionRepository.findByName(positionName);

        if (position.getAmount() >= amount) { // наличие >= покупки
            Supply supply = supplyRepository.findByNameOldestOne(positionName);
            if (supply.getAmount() > amount) {
                supplyRepository.updateAmountById(supply.getId(), supply.getAmount() - amount);
                positionRepository.decreaseAmountByName(positionName, amount);
            } else if (Objects.equals(supply.getAmount(), amount)) {
                supplyRepository.deleteById(supply.getId());
                positionRepository.decreaseAmountByName(positionName, amount);
            } else if (supply.getAmount() < amount) {
                Long cur = amount;

                while (cur != 0 && supply.getAmount() <= cur) {
                    cur -= supply.getAmount();
                    positionRepository.decreaseAmountByName(positionName, supply.getAmount());
                    supplyRepository.deleteById(supply.getId());
                    supply = supplyRepository.findByNameOldestOne(positionName);
                }
                if (cur > 0) {
                    supplyRepository.updateAmountById(supply.getId(), supply.getAmount() - cur);
                    positionRepository.decreaseAmountByName(positionName, cur);
                }
            }
            saleRepository.add(positionName, LocalDate.now(), amount, position.getPrice() * amount);

            return true;
        }
        return false;
    }

    @Override
    public List<SaleDto> findAll() {
        return mapper.salesToSaleDtos(saleRepository.findAll());
    }

    @Override
    public SaleDto findById(Long id) {
        return mapper.saleToSaleDto(saleRepository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}
