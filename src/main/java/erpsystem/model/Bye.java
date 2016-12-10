package erpsystem.model;

import org.springframework.stereotype.Component;

@Component
public class Bye {

    private String bye;

    public String getBye() {
        return "bye";
    }

    public void setBye(String bye) {
        this.bye = bye;
    }
}
