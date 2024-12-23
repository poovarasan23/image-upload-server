package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CURDController {

    @GetMapping(value = "/ping")
    public String ping(){
        return "Success";
    }

}
