package ahmad.sf.sfpetclinic.controller;

import ahmad.sf.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = {"","/","/index", "/index.html"} , method = RequestMethod.GET)
    public String listOwners(Model model) {
        model.addAttribute("title", "List of Owners");

        //get the all the owners
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.GET)
    public String findOwners(){
        return "notimplemented";
    }

    @RequestMapping(value = {"/{ownerId}"}, method = RequestMethod.GET)
    public ModelAndView showOwners(@PathVariable Long ownerId){
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));

        return modelAndView;

    }
}
