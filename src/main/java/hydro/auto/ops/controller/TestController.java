package hydro.auto.ops.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hydro.auto.ops.configuration.db_schema;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

    @Value("${server.database.password:dungsi}")
    private String string_test;
    @GetMapping("/demo")
    public String add(){
        System.out.println(string_test);
        return "test";
    }
}
