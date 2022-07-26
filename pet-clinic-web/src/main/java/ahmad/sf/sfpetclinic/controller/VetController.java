package ahmad.sf.sfpetclinic.controller;

import ahmad.sf.sfpetclinic.model.Vet;
import ahmad.sf.sfpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value ={"/vets", "/vets/index", "/vets/index.html", "/vets.html"} , method = RequestMethod.GET)
    public String listVets(Model model)
    {
        model.addAttribute("title", "List of Vets");
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @RequestMapping(value = {"/api/vets"}, method = RequestMethod.GET)
    public @ResponseBody Set<Vet> getVetJson(){
        return vetService.findAll();
    }
}
