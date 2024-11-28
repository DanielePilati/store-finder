package com.finder.store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finder.store.service.StoreService;

@Controller
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@GetMapping("/search")
	public String index(@RequestParam(name = "address") String address, Model model) {
		
		model.addAttribute("stores", storeService.getAll());
		
		return "home";
	}
}
