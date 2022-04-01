package liga.testsklad.service.impl;

import liga.testsklad.dto.CategoryDto;
import liga.testsklad.mapper.MapStructMapper;
import liga.testsklad.repository.CategoryRepository;
import liga.testsklad.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final MapStructMapper mapper;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(MapStructMapper mapper, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(CategoryDto categoryDto) {
        categoryRepository.add(mapper.categoryDtoToCategory(categoryDto));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAll() {
        return mapper.categoriesToCategoryDtos(categoryRepository.findAll());
    }

    @Override
    public CategoryDto findById(Long id) {
        return mapper.categoryToCategoryDto(categoryRepository.findById(id));
    }

    @Override
    public void updateById(Long id, String name) {
        categoryRepository.updateById(id, name);
    }
}
