package erpsystem.config;


import erpsystem.model.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Hello hello(){
        return new Hello("hello message");
    }

}
