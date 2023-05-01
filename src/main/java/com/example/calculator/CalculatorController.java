package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(@RequestParam("num1") Optional<Double> num1, @RequestParam("num2") Optional<Double> num2) {
        if (!num1.isPresent() || !num2.isPresent()) {
            return "Ошибка: Не все параметры предоставлены";
        }
        double result = calculatorService.add(num1.get(), num2.get());
        return String.format("%.2f + %.2f = %.2f", num1.get(), num2.get(), result);
    }
    @GetMapping("/minus")
    public String subtract(@RequestParam("num1") Optional<Double> num1, @RequestParam("num2") Optional<Double> num2) {
        if (!num1.isPresent() || !num2.isPresent()) {
            return "Ошибка: Не все параметры предоставлены";
        }
        double result = calculatorService.subtract(num1.get(), num2.get());
        return String.format("%.2f - %.2f = %.2f", num1.get(), num2.get(), result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Optional<Double> num1, @RequestParam("num2") Optional<Double> num2) {
        if (!num1.isPresent() || !num2.isPresent()) {
            return "Ошибка: Не все параметры предоставлены";
        }
        double result = calculatorService.multiply(num1.get(), num2.get());
        return String.format("%.2f * %.2f = %.2f", num1.get(), num2.get(), result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Optional<Double> num1, @RequestParam("num2") Optional<Double> num2) {
        if (!num1.isPresent() || !num2.isPresent()) {
            return "Ошибка: Не все параметры предоставлены";
        }
        if (num2.get() == 0) {
            return "Деление на 0 запрещено";
        }
        double result = calculatorService.divide(num1.get(), num2.get());
        return String.format("%.2f / %.2f = %.2f", num1.get(), num2.get(), result);
    }
}


