package com.codegym.service.impl;

import com.codegym.service.ICalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculationService {
    @Override
    public Integer doCalculation(Integer num1, Integer num2, String operator) {
        Integer result =null;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
