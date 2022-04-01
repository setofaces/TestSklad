package liga.testsklad.repository;

import liga.testsklad.model.Role;
import liga.testsklad.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface UserRepository {

    void add(User user) ;

    User findByEmail(@Param("email") String email);

    void  addRoles(@Param("userId") Long id, Set<Role> roles);
}
