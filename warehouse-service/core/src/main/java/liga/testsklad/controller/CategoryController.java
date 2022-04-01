package liga.testsklad.controller;

import liga.testsklad.dto.CategoryDto;
import liga.testsklad.logging.Loggable;
import liga.testsklad.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CategoryDto categoryDto) {
        categoryService.add(categoryDto);
    }

    @PostMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody String name) {
        categoryService.updateById(id, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id) {
        categoryService.deleteById(id);
    }
}
