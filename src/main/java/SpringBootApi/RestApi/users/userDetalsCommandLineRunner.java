package SpringBootApi.RestApi.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class userDetalsCommandLineRunner implements CommandLineRunner {

    private Logger logger=  LoggerFactory.getLogger(getClass());
    private UserDetailsRepository repository;

    public userDetalsCommandLineRunner(UserDetailsRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
       repository.save(new Userdetails("Divya","software backend"));
       repository.save(new Userdetails("Nitish","software backend intern")) ;
       repository.save(new Userdetails("Sanskar","Data Analyst"));

        List<Userdetails> users=repository.findByrole("software backend");
        users.forEach(user->logger.info(user.toString()));
    }
}
