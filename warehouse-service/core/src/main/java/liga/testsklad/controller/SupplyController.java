package liga.testsklad.controller;

import liga.testsklad.dto.SupplyDto;
import liga.testsklad.logging.Loggable;
import liga.testsklad.service.SupplyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Loggable
@RestController
@RequestMapping("/supply")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping("/all")
    public List<SupplyDto> getAll() {
        return supplyService.getAll();
    }

    @GetMapping("/{id}")
    public SupplyDto getById(@PathVariable Long id) {
        return supplyService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody SupplyDto supplyDto) {
        supplyService.add(supplyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id) {
        supplyService.deleteById(id);
    }
}
