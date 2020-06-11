package org.launchcode.hellospring.controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("hello")
@Controller
public class HelloController {

    //Handles request at path /hello/hello
//    @ResponseBody
//    public String hello() {
//        return "Hello Spring";
//    }

    // lives at /hello/goodbye
//    @ResponseBody
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye Spring";
//    }

    //Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello " + name + "!";
//    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("{coder}")
    public String helloWithPathParam(@PathVariable String coder, Model model) {
        String greeting = "Hello, " + coder + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //live at /hello/hello
    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String coder, Model model) {
        String greeting = "Hello, " + coder + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String createMessage(@RequestParam String coder, @RequestParam String lang) {
        if (lang.equals("French")) {
            return "Bonjour, " + coder + "!";
        } else if(lang.equals("Spanish")) {
            return "Hola, " + coder + "!";
        } else if(lang.equals("Russian")) {
            return "ZDRAS-TVUY-TE, " + coder + "!";
        } else if(lang.equals("Swahili")) {
            return "JAMBO, " + coder + "!";
        } else if(lang.equals("English")) {
            return "Hello, " + coder + "!";
        } else if(lang.equals("Japanese")) {
            return "KONNICHIWA, " + coder + "!";
        }
        return "Select a language.";
    }

    //live at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
   //     String html =
//                "<html>" +
//                        "<body>" +
//                        "<form method = 'post' action = '/hello'>" +
//                        "<select name='lang' id='lang-selector'>" +
//                        "<option value=''>--Choose a language--</option>" +
//                        "<option value='French'>French</option>" +
//                        "<option value='Spanish'>Spanish</option>"+
//                        "<option value='Russian'>Russian</option>"+
//                        "<option value='Swahili'>Swahili</option>"+
//                        "<option value='English'>English</option>"+
//                        "<option value='Japanese'>Japanese</option>"+
//                        "</select>" +
//                        "<input type = 'text' name = 'coder' />" +
//                        "<input type = 'submit' value = 'Greet Me!' />" +
//                        "</form>" +
//                        "</body>" +
//                        "</html>";
  //      return html;
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

    @GetMapping("numbers-list")
    public String numbers(Model model) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(20);
        numbers.add(70);
        model.addAttribute("numbers", numbers);
        return "numbers";
    }


}
