package liga.testsklad.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    private Long id;

    private String name;

    public Role(String role) {
        this.name = role;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
