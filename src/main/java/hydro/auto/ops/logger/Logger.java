package hydro.auto.ops.logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
    public static void addErrorLog(Throwable ex) {
        log.error(ex.toString());
    }

    public static void addInfoLog(String str) {
        log.info(str);
    }
}
