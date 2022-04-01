package liga.testsklad.repository;

import liga.testsklad.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryRepository {

    List<Category> findAll();

    Category findById(@Param("id") Long id);

    void add(Category category);

    void updateById(@Param("id")Long id,@Param("name") String name);

    void deleteById(@Param("id")Long id);
}
