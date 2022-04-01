package liga.testsklad.controller;

import liga.testsklad.dto.SaleDto;
import liga.testsklad.logging.Loggable;
import liga.testsklad.service.SaleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Loggable
@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<SaleDto> getAll() {
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    public SaleDto getById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @PostMapping("/sell")
    public void sell(@RequestParam String name, @RequestParam Long amount) {
        saleService.sell(name, amount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id) {
        saleService.deleteById(id);
    }
}
