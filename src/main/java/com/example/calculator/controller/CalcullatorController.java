package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcullatorController {

    private final CalculatorService calculatorService;

    public CalcullatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")

    public String hello() {
        return """
                <h1 style= color: red; text-align: center>Добро пожаловать в калькулятор";
                """;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("+", a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("-", a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a, @RequestParam(value = "num2", required = false ) Float b) {
        return buildView("*", a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1") Float a, @RequestParam(value = "num2", required = false) Float b) {
        return buildView("/", a, b);
    }

    private String buildView(String operation, Float operand1, Float operand2) {
        if (operand1 == null){
            return "Не передано первое число!";
        } else if (operand2 == null) {
            return "Не передано второе число";
        }
        if ("/".equals(operation) && operand2 == 0) {
            return "Делить на 0 нельзя";
        }
        float result;
        switch (operation) {
            default:
            case "+":
                result = calculatorService.plus(operand1, operand2);
                break;
            case "-":
                result = calculatorService.minus(operand1, operand2);
                break;
            case "*":
                result = calculatorService.multiply(operand1, operand2);
                break;
            case "/":
                result = calculatorService.divide(operand1, operand2);
                break;
        }
        return operand1+ " " +operation+ " "+operand2 + " = " + result;
    }
}
