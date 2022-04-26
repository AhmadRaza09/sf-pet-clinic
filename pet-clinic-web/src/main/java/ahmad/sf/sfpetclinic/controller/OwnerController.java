package ahmad.sf.sfpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping(value = {"","/","/index", "/index.html"} , method = RequestMethod.GET)
    public String listOwners(Model model)
    {
        model.addAttribute("title", "List of Owners");
        return "owners/index";
    }
}
