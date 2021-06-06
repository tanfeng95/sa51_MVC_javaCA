package team5.service;

import java.util.Optional;

import team5.model.FixsetDetails;

public interface FixsetDetailsService extends IService<FixsetDetails> {

	Optional<FixsetDetails> optionalFindById(Long id);

}
