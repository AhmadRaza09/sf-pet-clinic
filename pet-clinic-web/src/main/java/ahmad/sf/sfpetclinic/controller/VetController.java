package ahmad.sf.sfpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VetController {


    @RequestMapping(value ={"/vets", "/vets/index", "/vets/index.html"} , method = RequestMethod.GET)
    public String listVets(Model model)
    {
        model.addAttribute("title", "List of Vets");
        return "vets/index";
    }
}
