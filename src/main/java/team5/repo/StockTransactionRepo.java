package team5.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import team5.model.StockTransaction;

public interface StockTransactionRepo extends JpaRepository<StockTransaction, Long> {

}
