package liga.testsklad.repository;

import liga.testsklad.model.LogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogRepository {

    void add(LogEntity logEntity);

    List<LogEntity> findAll();
}
