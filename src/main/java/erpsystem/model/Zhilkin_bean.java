package erpsystem.model;

import org.springframework.stereotype.Controller;

/**
 * Created by Alexandr Zhilkin on 23.12.2016.
 */
@Controller
public class Zhilkin_bean {
    private String message = "Надеюсь я всё исправил.";

    public String getMessage(){
        return message;
    }
}
