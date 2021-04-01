package com.myproject.datasolutions.assets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.datasolutions.employee.EmployeeService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class AssetController {

	@Autowired
	private AssetService astService;
	
	//Map to the employee page passing in a model object
	@RequestMapping("/asset")
	public String viewAssetPage(Model model) {
		List<Asset> listAssets = astService.listAll();
		model.addAttribute("listAssets", listAssets);
		return "asset";
	}
	
	@RequestMapping("/asset/edit/{id}")
	public ModelAndView showEditAssetPage(@PathVariable("id") int id) {
	    ModelAndView mav = new ModelAndView("edit_asset");
	    Asset asset = astService.get(id);
	    mav.addObject("asset", asset);     
	    return mav;
	}
	
	@RequestMapping(value = "asset/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("asset") Asset asset) {
		astService.save(asset);
		
		// Redirect to the asset page to view the edits.
		return "redirect:/asset";
	}
	
	@RequestMapping("/asset/new")
	public String showNewAssetPage(Model model) {
		Asset asset = new Asset();
		model.addAttribute("asset", asset);
		
		return "new_asset";
	}
	
	@RequestMapping("/asset/delete/{id}")
	public String deleteAsset(@PathVariable("id") int id) {
		astService.delete(id);
		
		//redirect back to the employees
		return "redirect:/asset";
	}
	
	//See: https://attacomsian.com/blog/spring-boot-upload-parse-csv-file
	//Map to the upload csv function
	@RequestMapping("/asset/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        // check if file is empty
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            model.addAttribute("status", false);
        } else {
        	// parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Asset> csvToBean = new CsvToBeanBuilder<Asset>(reader)
                        .withType(Asset.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                java.util.List<Asset> ListAssets = csvToBean.parse();
                for(Asset a : ListAssets) {
                	//	NOTE: an odd bug with the getStatus method causes extra whitespace in the return string.
                	astService.save(new Asset(a.getAqrDate(), a.getAst_SN(), a.getAstModel(), a.getStatus().replaceAll("\\s", ""), a.getManufacturer(), a.getAst_type().replaceAll("\\s", "")));
                }

                // save users list on model
                model.addAttribute("message", "CSV file has been uploaded, assets have been stored");
                model.addAttribute("ListAssets", ListAssets);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "status";
        }
}
