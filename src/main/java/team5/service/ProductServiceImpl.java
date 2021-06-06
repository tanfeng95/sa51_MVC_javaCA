package team5.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import team5.model.Product;
import team5.repo.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepo prepo;
	
	@Override
	public void save(Product product) {
		prepo.save(product);
	}
	
	@Override
	public Product findById(Long id) {
		return prepo.findById(id).get();
	}
	
	@Override
	public Product findByName(String name) {
		return prepo.findByName(name).get(0);
	}
	
	@Override
	public List<Product> findAll(){
		return prepo.findAll(); 
	}
	
	@Override
    public List<Product> searchByKeyword(String keyword) {
        if (keyword != null) {
            return prepo.search(keyword);
        }
        return prepo.findAll();
    }
	
	@Override
	public ArrayList<String> FindAllPartNumber(){
		List<Product> product = prepo.findAll();
		ArrayList<String> partnum = new ArrayList<String>();
		for (Iterator<Product> iterator = product.iterator(); iterator.hasNext();) {
			Product product2 = (Product) iterator.next();
			partnum.add(product2.getPartNumber());
			
		}
		return partnum;
	}
	     
	@Override
	public void updateStock(Long quantity, Long id) {		
		prepo.reduceStock(quantity, id);	
	}
	
	@Override
	public void delete(Product product) {
		prepo.delete(product);
		
	}
	
	@Override
	public Optional<Product> OptionalFindById(Long id) {
		return prepo.findById(id);
	}
	public Page<Product> listProducts(String keywords, int page,int size) {
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable= PageRequest.of(page,size, sort);
		System.out.println(keywords);
		if(keywords != null) {
			return prepo.search2(keywords,pageable);
		}
		return prepo.findAll(pageable);
	}

	public List<Product> listAllProducts(String keyword) {		
		System.out.println(keyword);
			if(keyword != null) {
				return prepo.search(keyword);
			}
			return prepo.findAll();		
	}


}
