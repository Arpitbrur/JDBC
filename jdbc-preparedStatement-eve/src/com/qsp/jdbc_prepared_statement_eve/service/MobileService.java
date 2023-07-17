package com.qsp.jdbc_prepared_statement_eve.service;

import java.util.List;

import com.qsp.jdbc_prepared_statement_eve.dao.MobileDao;
import com.qsp.jdbc_prepared_statement_eve.dto.Mobile;

public class MobileService {

	MobileDao dao = new MobileDao();
	
	// Insert Mobile--------------------------------------------------------------------
	public void insertMobile(Mobile mobile) {
		dao.insertMobile(mobile);
	}
	
	// update Mobile---------------------------------------------------------------------------	
	public void updateMobile(int id, String color, double price, String camera) {
		dao.updateMobile(id, color, price, camera);
	}
		
	// delete Mobile------------------------------------------------------------------------        
	public void deleteMobile(int id) {
		dao.deleteMobile(id);
	}
	
	
	//insert Addbatch----------------------------------------------------------------------
	public void insertAddBatch(List<Mobile> mobile) {
		dao.insertAddBatch(mobile);
	}
		
	// display Mobile-----------------------------------------------------------------
	public List<Mobile> displayMobiles(){		
		List<Mobile> list = dao.displayMobiles();
		return list;
	}
		
		
	
}
