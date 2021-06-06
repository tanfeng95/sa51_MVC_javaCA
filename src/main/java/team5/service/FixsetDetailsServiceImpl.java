package team5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.model.FixsetDetails;
import team5.repo.FixsetDetailsRepo;


@Service
@Transactional
public class FixsetDetailsServiceImpl implements FixsetDetailsService {

	@Autowired
	FixsetDetailsRepo fixsetDetailsRepo;
	
	@Override
	public void save(FixsetDetails x) {
		fixsetDetailsRepo.save(x);

	}

	@Override
	public FixsetDetails findById(Long id) {
		return fixsetDetailsRepo.findById(id).get();
	}

	@Override
	public List<FixsetDetails> findAll() {
		return fixsetDetailsRepo.findAll();
	}

	@Override
	public void delete(FixsetDetails x) {
		fixsetDetailsRepo.delete(x);
	}
	
	@Override
	public Optional<FixsetDetails> optionalFindById(Long id){
		return fixsetDetailsRepo.findById(id);
	}

}
