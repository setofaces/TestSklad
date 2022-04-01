package liga.testsklad.repository;

import liga.testsklad.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleRepository {

    Role findById(Long id);

    List<Role> findAll();

    void addAll(Set<Role> roles);
}
