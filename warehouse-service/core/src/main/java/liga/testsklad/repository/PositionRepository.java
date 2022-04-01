package liga.testsklad.repository;

import liga.testsklad.model.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PositionRepository {

    List<Position> findAll();

    Position findByName(@Param("name") String name);

    Position findById(@Param("id") Long id);

    void add(Position position);

    void updateById(@Param("id")Long id, Position position);

    void deleteById(@Param("id")Long id);

    void deleteByName(@Param("name") String name);

    void decreaseAmountByName(@Param("name") String name, @Param("amount") Long amount);

    void increaseAmountByName(@Param("name") String name,@Param("amount") Long amount);
}
