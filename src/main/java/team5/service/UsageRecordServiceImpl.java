package team5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team5.model.UsageRecord;
import team5.repo.UsageRecordRepo;

@Service
public class UsageRecordServiceImpl implements UsageRecordService {
	
	@Autowired
	UsageRecordRepo urrepo;
	
	
	public void save(UsageRecord ur) {
		urrepo.save(ur);
	}
	
	//@Transactional
	//public List<UsageRecord> checkTransectionHistory(long id ) {
	//	return urepo.findUsageRecord(id);
	//}
	
	@Transactional
	public UsageRecord findById(Long id) {
		return urrepo.findById(id).get();
	}
	
	@Transactional
	public List<UsageRecord> findAll(){
		return urrepo.findAll();
	}
	
	public void delete(UsageRecord ur) {
		urrepo.delete(ur);
	}

}
