package com.rayen.boisson.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.rayen.boisson.entities.Boisson;
import com.rayen.boisson.service.BoissonService;


import jakarta.validation.Valid;
import com.rayen.boisson.entities.Type;


@Controller

public class BoissonController {
	   @Autowired
       BoissonService boissonService;
	   
	   @RequestMapping("/myView")
	   public String myView()
	   {
	   return "myView";
	   }

	   @RequestMapping("/ListeBoissons")
	   public String listeBoissons(ModelMap modelMap,
			   @RequestParam (name="page",defaultValue = "0") int page,
			   @RequestParam (name="size", defaultValue = "2") int size)
			   {
			   Page<Boisson> b = boissonService.getAllBoissonsParPage(page, size);
			   modelMap.addAttribute("boissons",b);
			    modelMap.addAttribute("pages", new int[b.getTotalPages()]);
			   modelMap.addAttribute("currentPage", page);
			   return "listeBoisson";
			   }
			  
	   @RequestMapping("/showCreate")
	   public String showCreate(ModelMap modelMap)
	   {
			List<Type> t = boissonService.getAllTypes(); 
		   modelMap.addAttribute("boisson", new Boisson());
		   modelMap.addAttribute("mode", "new");
			 modelMap.addAttribute("types", t);
	   return "formBoisson";
	   }
   
	   @RequestMapping("/saveBoisson")
	   public String saveBoisson(@Valid Boisson boisson,BindingResult bindingResult)
	   {
	   if (bindingResult.hasErrors()) return "formBoisson";

	   boissonService.saveBoisson(boisson);

	   return "formBoisson";
	   }
	    
	   @RequestMapping("/supprimerBoisson")
	   public String supprimerBoisson(@RequestParam("id") Long id,
			   ModelMap modelMap,
			   @RequestParam (name="page",defaultValue = "0") int page,
			   @RequestParam (name="size", defaultValue = "2") int size)
			   {
		       boissonService.deleteBoissonById(id);
			   Page<Boisson> b = boissonService.getAllBoissonsParPage(page,size);
					   modelMap.addAttribute("boissons", b);
					   modelMap.addAttribute("pages", new int[b.getTotalPages()]);
					   modelMap.addAttribute("currentPage", page);
					   modelMap.addAttribute("size", size);
	               return "listeBoisson";
	   }
	   
	   @RequestMapping("/modifierBoisson")
	  public String editerBoisson(@RequestParam("id") Long id,
	   ModelMap modelMap)
	  {
		   Boisson b= boissonService.getBoisson(id);
			 List<Type> t = boissonService.getAllTypes();
	  modelMap.addAttribute("boisson",b);
	  modelMap.addAttribute("mode", "edit");
		 modelMap.addAttribute("types", t);
	  return "formBoisson";
	  }
	   
	   
	   @RequestMapping("/updateBoisson")
	   public String updateProduit(@ModelAttribute("boisson") Boisson boisson, @RequestParam("date") String date,
	    ModelMap modelMap) throws ParseException
	   {
		   //conversion de la date
		   SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		   Date dateServir = dateformat.parse(String.valueOf(date));
		   boisson.setDateServir(dateServir);

		   boissonService.updateBoisson(boisson);
	    List<Boisson> b = boissonService.getAllBoisson();
	    modelMap.addAttribute("produits", b);
	   return "listeBoissons";
	   }
 
}
