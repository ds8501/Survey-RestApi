package SpringBootApi.RestApi.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailsRestRepository extends JpaRepository<Userdetails,Long> {
  List<Userdetails> findByrole(String role);

}
