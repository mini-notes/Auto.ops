package hydro.auto.ops.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class db_schema {
    @Value("${server.database.password:dungsi}")
    private static String string_test;
    public static String database_pass = string_test;
}
