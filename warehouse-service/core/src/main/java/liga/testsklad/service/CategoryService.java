package liga.testsklad.service;

import liga.testsklad.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    void add(CategoryDto categoryDto);

    void deleteById(Long id);

    List<CategoryDto> getAll();

    CategoryDto findById(Long id);

    void updateById(Long id, String name);
}
