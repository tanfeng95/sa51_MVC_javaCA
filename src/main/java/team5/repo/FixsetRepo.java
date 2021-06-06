package team5.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import team5.model.Fixset;

public interface FixsetRepo extends JpaRepository<Fixset, Long> {

	public Fixset findByName(String name);

}
