package team5.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team5.model.Product;
import team5.service.ProductService;
import team5.service.ProductServiceImpl;
import team5.service.SessionService;
import team5.service.SessionServiceImpl;
import team5.service.SupplierService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService product_svc;
	
	@Autowired
	private SupplierService supplier_svc;
	
	@Autowired
	private SessionService session_svc;
	
	@Autowired
	public void SetImplimentation(ProductServiceImpl product_svcimpl, SessionServiceImpl session_svcimpl) {
		this.product_svc = product_svcimpl;
		this.session_svc = session_svcimpl;
	}

	@InitBinder()
	protected void initBinder(WebDataBinder binder) {
		
	}
	
	
	@GetMapping("/add")
	public String showProductForm(Model model) {
		model.addAttribute("supplier", supplier_svc.findAll());
		model.addAttribute("product", new Product());
		return "productform";
	}
	
	
	@GetMapping("/save")
	public String saveProductForm(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("supplier", supplier_svc.findAll());
			return "productform";
		}
		product_svc.save(product);
		return "forward:/product/listproducts";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("supplier", supplier_svc.findAll());
		model.addAttribute("product", product_svc.findById(id));
		return "productform";
	}
	
	
	@GetMapping("/listproducts")
	public String listProductForm(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page,@Param("keyword") String keyword,
			@RequestParam(value ="size", defaultValue = "3") Integer size, HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";

		System.out.println("Stock add");
		Page<Product> listProducts = product_svc.listProducts(keyword,page, size);
		model.addAttribute("products", listProducts);
		model.addAttribute("supplier", supplier_svc.findAll());
        model.addAttribute("pageCount",listProducts.getTotalPages()-1);
	    model.addAttribute("keyword", keyword); 
	    model.addAttribute("hasPermission",session_svc.hasPermission(session));
		return "products";
	}
	

	
	@GetMapping("/delete/{id}")
	public String deleteMethod(Model model, @PathVariable("id") Long id) {
		Product product = product_svc.findById(id);
		product_svc.delete(product);
		return "forward:/product/listproducts";
	}
	
	@RequestMapping("/reorderreport")
	public String showReorderReport(Model model,HttpSession session) {
		if (session_svc.isNotLoggedIn(session)) return "redirect:/user/login";
		if (session_svc.hasNoPermission(session)) return "nopermission";
		
		List<Product> listProducts = product_svc.findAll();
	      long total = listProducts.stream()
	    		    .map(i -> {long val = i.getReorderLevel() - i.getUnit(); if (val > 0) { if (val > i.getMinReoderLevel()) {return val * i.getPriceFWholesale();} else {return i.getMinReoderLevel() * i.getPriceFWholesale();} } else {return (long)0;} })
		            .reduce((n1, n2) -> n1 + n2)
		            .get();
	      
		model.addAttribute("products", listProducts);
		model.addAttribute("total", total);
		model.addAttribute("supplier", "S1");
		return "reorderReport";
		
	}

}
