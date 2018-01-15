package lab.zlren.house.web.config.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zlren
 * @date 2018-01-15
 */
@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public String error500(HttpServletRequest request, Exception e) {
        log.error(e.getMessage());
        log.error(request.getRequestURI() + " encounter 500");
        return "error/500";
    }
}
