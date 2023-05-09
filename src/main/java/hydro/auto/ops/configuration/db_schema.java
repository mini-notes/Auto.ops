package hydro.auto.ops.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class db_schema {
    @Value("${server.database.password:dungsi}")
     private String string_test;

    public String getString_test() {
        return string_test;
    }
}
