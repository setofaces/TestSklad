package liga.testsklad.controller;

import liga.testsklad.dto.PositionDto;

import liga.testsklad.logging.Loggable;
import liga.testsklad.service.PositionService;
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
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<PositionDto> getAll() {
        return positionService.getAll();
    }

    @GetMapping("/{id}")
    public PositionDto getById(@PathVariable Long id) {
        return positionService.findById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody PositionDto positionDto) {
        positionService.add(positionDto);

    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody PositionDto positionDto) {
        positionService.updateById(id, positionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id) {
        positionService.deleteById(id);
    }
}
