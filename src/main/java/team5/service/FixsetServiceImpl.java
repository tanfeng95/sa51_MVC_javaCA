package team5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.model.Fixset;
import team5.model.FixsetDetails;
import team5.repo.FixsetDetailsRepo;
import team5.repo.FixsetRepo;

@Service
@Transactional
public class FixsetServiceImpl implements FixsetService {

	@Autowired
	FixsetRepo fixsetRepo;
	
	@Autowired
	FixsetDetailsRepo fixsetDetailsRepo;
	
	@Override
	public void save(Fixset x) {
		fixsetRepo.save(x);
	}

	@Override
	public Fixset findById(Long id) {
		return fixsetRepo.findById(id).get();
	}
	
	@Override
	public Optional<Fixset> optionalFindById(Long id) {
		return fixsetRepo.findById(id);
	}

	@Override
	public List<Fixset> findAll() {
		return fixsetRepo.findAll();
	}

	@Override
	public void deletebyId(Long id) {
		Fixset fixset = fixsetRepo.findById(id).get();
		List<FixsetDetails> fixDetails = fixset.getFixsetList();
		for (FixsetDetails item:fixDetails) {
			fixsetDetailsRepo.delete(item);
		}
		fixsetRepo.delete(fixset);
	}

	@Override
	public void delete(Fixset x) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Fixset findByName(String name) {
		return fixsetRepo.findByName(name);
	}

}
