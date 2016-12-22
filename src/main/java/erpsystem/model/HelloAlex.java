package erpsystem.model;

import org.springframework.stereotype.Controller;

/**
 * Created by Саша on 19.12.2016.
 */
@Controller
public class HelloAlex {

    String message;

    public HelloAlex() {
        this.message = "Hello Alex!";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
