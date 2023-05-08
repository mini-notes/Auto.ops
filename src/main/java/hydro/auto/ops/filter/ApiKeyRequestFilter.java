package hydro.auto.ops.filter;

import org.springframework.stereotype.Component;

import java.io.IOException;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
@Component
public class ApiKeyRequestFilter extends GenericFilterBean{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();

        if(path.startsWith("/api") == false){
            chain.doFilter(request, response);
            return;
        }

        String key = req.getHeader("X-API-KEY") == null ? "" : req.getHeader("X-API-KEY");
//        LOG.info("Trying key: " + key);
        if (key == null || key.isEmpty() || key.trim().isEmpty()) {
            ((HttpServletResponse) response).setStatus(401);
            response.getOutputStream().write("API Key is missing!".getBytes());
            return;
        }

//        if (key !=null && key !="123")
//        {
//            ((HttpServletResponse) response).setStatus(403);
//            response.getOutputStream().write("API Key is invalid".getBytes());
//            return;
//        }

        chain.doFilter(request, response);
    }
}
