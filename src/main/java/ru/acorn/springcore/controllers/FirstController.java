package ru.acorn.springcore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {      //Хороший тон создавать вью в папке, которые относятся к конкретному контроллеру
    @GetMapping("/hello")         // firstController - папка first во views
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {                           //(HttpServletRequest request)
        //String name = request.getParameter("name");             //получаем доступ к параметрам из гет запроса
        //String surname = request.getParameter("surname");       //т.е. /first/hello?name=Ant&surname=Boris,
        //из строки браузера метод заберет данные в консоль
        //value = "name",required = false, можно передавать пустой гетзапрос без ошибки, в значении тру - ошибка
        //System.out.println("Hello, "+ name + " " + surname);

        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;
        switch (action) {
            case "multiplication":
                 result = (a * b);
                 break;
            case "addition":
                 result = (a + b);
                 break;
            case "subtraction":
                result = (a - b);
                break;
            case "division":
                result =  a / (double)b;
                break;
            default: result = 0;
        }
        model.addAttribute("result", result);
        return "first/calculator";

    }
}
