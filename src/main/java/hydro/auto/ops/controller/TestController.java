package hydro.auto.ops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hydro.auto.ops.configuration.db_schema;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

//    @Value("${server.database.password:dungsi}")
//    private String string_test;

    @Autowired
    private Environment env;
    @Autowired
    private db_schema db_schema_test;
    @GetMapping("/demo")
    public String add(){
        System.out.println(db_schema_test.getString_test());
        System.out.println(env.getProperty("server.database.password"));
        return "test";
    }
}
