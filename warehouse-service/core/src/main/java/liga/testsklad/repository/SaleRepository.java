package liga.testsklad.repository;

import liga.testsklad.model.Sale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SaleRepository {

    List<Sale>  findAll();

    Sale findById(@Param("id") Long id);

    void add(@Param("positionName") String positionName,@Param("date") LocalDate date,
             @Param("amount") Long amount,@Param("moneySpent") Long moneySpent);

    void deleteById(@Param("id") Long id);
}
