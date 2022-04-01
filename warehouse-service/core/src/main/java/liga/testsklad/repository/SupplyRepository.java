package liga.testsklad.repository;

import liga.testsklad.model.Supply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplyRepository {

    List<Supply> findAll();

    Supply findById(@Param("id")Long id);

    List<Supply> findByName(@Param("name")String name);

    void deleteById(@Param("id") Long id);

    void add(Supply supply);

    Supply findByNameOldestOne(@Param("name") String name);

    void updateAmountById(@Param("id") Long id,@Param("amount") Long amount);

}
