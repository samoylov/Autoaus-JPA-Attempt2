package autohaus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

    @RequestMapping(value = "resttest", method = RequestMethod.POST)
    public String restTest() {
        return "";
    }
}
