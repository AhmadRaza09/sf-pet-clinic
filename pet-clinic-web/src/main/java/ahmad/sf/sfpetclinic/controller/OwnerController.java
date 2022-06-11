package ahmad.sf.sfpetclinic.controller;

import ahmad.sf.sfpetclinic.model.Owner;
import ahmad.sf.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");

    }

//    @RequestMapping(value = {"","/","/index", "/index.html"} , method = RequestMethod.GET)
//    public String listOwners(Model model) {
//        model.addAttribute("title", "List of Owners");
//
//        //get the all the owners
//        model.addAttribute("owners", ownerService.findAll());
//        return "owners/index";
//    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.GET)
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @RequestMapping(value = {"/{ownerId}"}, method = RequestMethod.GET)
    public ModelAndView showOwners(@PathVariable Long ownerId){
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));

        return modelAndView;

    }

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String processFindForm(Owner owner, BindingResult result, Model model){

        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.findAllByLastNameLike(owner.getLastName());

        if(owners.isEmpty()){
//            owners.rejectedValues()
            result.rejectValue("lastName", "not found", "not found");
            return "owners/findOwners";
        } else if(owners.size() == 1){
            owner = owners.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else{
            model.addAttribute("selections", owners);
            return "owners/ownersList";
        }
    }
}
