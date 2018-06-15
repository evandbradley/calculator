package com.el.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.el.calculator.models.Calculator;

@Controller
@RequestMapping("/")
public class CalculatorController {

    @GetMapping("")
    public String showDefaultPage() {
        return "calculator";
    }

    @PostMapping("")
    public ModelAndView convertNumber(double firstNumber, double secondNumber, String operation) {
        String result = Calculator.calculate(operation, firstNumber, secondNumber);

        ModelAndView mv = new ModelAndView("calculator");
        mv.addObject("result", result);
        return mv;
    }

}
