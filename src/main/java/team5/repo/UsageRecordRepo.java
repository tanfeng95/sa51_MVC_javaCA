package team5.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import team5.model.UsageRecord;

public interface UsageRecordRepo extends JpaRepository<UsageRecord, Long> {
	
	//@Query("Select u from UsageRecord u where u.usageRecordDetail.product.id =:pid")
	//public List<UsageRecord> findUsageRecord(@Param("pid")long pid);
}
