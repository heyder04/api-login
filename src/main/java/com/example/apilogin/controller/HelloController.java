package  com.example.apilogin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController{

    @GetMapping("/")
    public String greeting(){
        return  "Hello World";
    }

    @GetMapping("/secured")
    public String secured(){
        return "If you see this you are logged in ";
    }

}