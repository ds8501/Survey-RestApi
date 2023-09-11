package SpringBootApi.RestApi.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Userdetails {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String role;

    public Userdetails( String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Userdetails() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
