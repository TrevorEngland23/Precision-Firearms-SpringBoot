
package com.example.demo.controllers;
import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel) {
        InhousePart inhousepart = new InhousePart();
        theModel.addAttribute("inhousepart", inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel) {
        // Add the part object to the model so it's accessible in the view
        theModel.addAttribute("inhousepart", part);

        // Additional custom validation logic if needed
        if (part.getMinInv() != null && part.getMaxInv() != null && part.getMinInv() > part.getMaxInv()) {
            theBindingResult.rejectValue("minInv", "error.minInv", "Min cannot be greater than Max");
        }
        if (part.getInv() < part.getMinInv() || part.getInv() > part.getMaxInv()) {
            theBindingResult.rejectValue("inv", "error.inv", "Inventory must be between " + part.getMinInv() + " and " + part.getMaxInv());
        }

        // Check if any validation errors are present
        if (theBindingResult.hasErrors()) {
            return "InhousePartForm";  // Return to form page if there are errors
        }

        // If validation passes, save the part
        PartService repo = context.getBean(PartServiceImpl.class);
        repo.save(part);

        return "confirmationAddPart";
    }
}

