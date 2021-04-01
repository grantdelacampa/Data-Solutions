/*
 * Grant De La Campa
 * 2021
 * AppController: Mapping for odds and ends not associated with a model
 */
package com.myproject.datasolutions;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.datasolutions.assets.AssetService;

@Controller
public class AppController {	
	
	@Autowired
	private AssetService astService;
	
	//Map to the index page
	@RequestMapping("/")
	public String viewIndexPage(Model model) {
		//Build the mapping for the asset status graph
		Map<String, Integer> graphData = new TreeMap<>();
		graphData.put("Deployed", astService.countStatus("Deployed"));
		graphData.put("Spare", astService.countStatus("Spare"));
		graphData.put("Broken", astService.countStatus("Broken"));
		graphData.put("Repair", astService.countStatus("Repair"));
		model.addAttribute("chartData", graphData);	
		Map<String, Integer> graphData2 = new TreeMap<>();
		graphData2.put("Laptop", astService.countType("Laptop"));
		graphData2.put("Desktop", astService.countType("Desktop"));
		graphData2.put("POS", astService.countType("POS"));
		graphData2.put("Phone", astService.countType("Phone"));
		model.addAttribute("chart2Data", graphData2);
		return "index";
	}
	
	//Map to the import csv page
	@RequestMapping("/import")
	public String viewImportPage() {
		return "import_csv";
	}
	
	/*----------------------------------------------------------------------------------
	 * 		Error page mapping
	 ----------------------------------------------------------------------------------*/
	
	@RequestMapping("Error")
	public String viewErrorPage() {
		return "error";
	}
}
