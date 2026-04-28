package hello.core.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotEnoughStocksException.class)
    public String handleStockException(NotEnoughStocksException e, RedirectAttributes attributes) {
        // 에러 메시지를 FlashAttribute에 담는것
        attributes.addFlashAttribute("message", e.getMessage());

        // 사용자가 시도한 페이지로 다시 보냄
        return "redirect:/orders/createOrders";
    }

    @ExceptionHandler(WrongStocksInsertionException.class)
    public String handleWrongStocksInsertionException(WrongStocksInsertionException e, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", e.getMessage());

        return "redirect:/products/createProduct";
    }


}
