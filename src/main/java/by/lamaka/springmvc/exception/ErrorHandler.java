package by.lamaka.springmvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BookAlreadyExistException.class)
    public String BookAlreadyExistHandler(Exception e, WebRequest request, Model model) {
        model.addAttribute("message", e.getMessage());
        model.addAttribute("details", request.getDescription(false));
        return "error";
    }
}
