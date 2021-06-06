package team5.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import team5.model.Supplier;
import team5.service.SessionService;
import team5.service.SessionServiceImpl;
import team5.service.SupplierService;
import team5.service.SupplierServiceImpl;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplier_svc;
	
	@Autowired
	private SessionService session_svc;
	
	@Autowired 
	public void setImplimentation(SupplierServiceImpl supplier_svcimpl, SessionServiceImpl session_svcimpl) {
		this.supplier_svc = supplier_svcimpl;
		this.session_svc = session_svcimpl;
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";
		if (session_svc.hasNoPermission(session)) return "nopermission";
		
		model.addAttribute("suppliers", supplier_svc.findAll());
		return "suppliers";
			
	}
	
	@RequestMapping(value = "/add")
	public String addForm(Model model,HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";
		if (session_svc.hasNoPermission(session)) return "nopermission";
		
		model.addAttribute("suppliers", new Supplier());
		return "supplierform";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model,HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";
		if (session_svc.hasNoPermission(session)) return "nopermission";
		
		model.addAttribute("suppliers", supplier_svc.findById(id));
		return "supplierform";
	}
	
	@RequestMapping(value = "/save")
	public String saveSupplier(@ModelAttribute("supplier") @Valid Supplier supplier,
			BindingResult bindingResult, Model model, HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";
		if (session_svc.hasNoPermission(session)) return "nopermission";
		if (bindingResult.hasErrors()) {
			model.addAttribute("suppliers", new Supplier());
			return "supplierform";
		}
		
		supplier_svc.save(supplier);
		return "forward:/supplier/list";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteSupplier(@PathVariable("id") Long id,HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";
		if (session_svc.hasNoPermission(session)) return "nopermission";
		
		supplier_svc.delete(supplier_svc.findById(id));
		return "forward:/supplier/list";
	}
}
