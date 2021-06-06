package team5.service;

import java.util.Optional;

import team5.model.Fixset;

public interface FixsetService extends IService<Fixset>{

	void deletebyId(Long id);

	Fixset findByName(String name);

	Optional<Fixset> optionalFindById(Long id);
	
}
