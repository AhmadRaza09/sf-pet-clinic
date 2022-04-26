package ahmad.sf.sfpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value ={"","/", "index", "index.html"} , method = RequestMethod.GET)
    public String index(Model model)
    {
        model.addAttribute("title", "Pet Clinic Index");
        return "index";
    }
}
