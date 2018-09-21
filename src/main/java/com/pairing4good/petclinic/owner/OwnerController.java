package com.pairing4good.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class OwnerController {

    public static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerController(OwnerRepository ownerRepository) {

        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/owners/new")
    public String create(Map<String, Object> model) {
        model.put("owner", new Owner());
        return OWNERS_CREATE_OR_UPDATE_OWNER_FORM;
    }

    public String save(Owner owner, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return OWNERS_CREATE_OR_UPDATE_OWNER_FORM;
        }else {
            ownerRepository.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
