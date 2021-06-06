package team5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team5.model.Supplier;
import team5.repo.SupplierRepo;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepo srepo;
	
	public void save(Supplier supplier) {
		srepo.save(supplier);
	}
	
	public Supplier findById(Long id) {
		return srepo.findById(id).get();
	}
	
	public Supplier findByName(String name) {
		return srepo.findByName(name).get(0);
	}
	
	public List<Supplier> findAll(){
		return srepo.findAll(); 
	}
	
	public void delete(Supplier supplier) {
		srepo.delete(supplier);
	}
	
}
