package SpringBootApi.RestApi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "hello world";
    }

    @RequestMapping("/helloWorld-bean")
    public HelloWorlBean helloWorldBean(){
        return new HelloWorlBean ("hello world");
    }

    @RequestMapping("/helloWorld-path-param/{name}/message/{message}")
    public HelloWorlBean helloWorldMultiplePathParam(@PathVariable String name, @PathVariable String message){
        return new HelloWorlBean ("hello world  "+name+" "+message);
    }
}
