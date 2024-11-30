package com.finder.store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finder.store.model.Store;
import com.finder.store.service.StoreService;


@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping()
	public String homePage(Model model){
		
		model.addAttribute("searched", false);
		model.addAttribute("search", new Store());
		//store index
		model.addAttribute("stores", storeService.getAll());
		
		return "home";
	}
}
