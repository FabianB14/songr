package com.brooksfabe.songr.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    //in node js our controllers had lines lin app.get ("/req,res,)
    @GetMapping("/")
    public String getHome(){
        System.out.println("somebody got the root");
        return "helloworld";
    }
    @GetMapping("/hello/{word}")
    public String sayHello(@PathVariable String word, Model message){
        message.addAttribute("theWord",word);
        return "sayHello";
    }

    @GetMapping("/hello/reverse")
    public String getReversed(@RequestParam(required = false, defaultValue = "friendly") String word, Model message){
        String reversedString = reversed(word);
        message.addAttribute("sentence", reversedString);
        return "reverseme";
    }
    @GetMapping("/capitalize/{capWord}")
    public String capitalWord(@PathVariable String capWord, Model message){
        String wordCapped = capWord.toUpperCase();
        message.addAttribute("capitalized",wordCapped);
        return "capitalword";
    }
    public static String reversed(String word){
        String reversedString = new StringBuffer(word).reverse().toString();
        return reversedString;
    }
}
