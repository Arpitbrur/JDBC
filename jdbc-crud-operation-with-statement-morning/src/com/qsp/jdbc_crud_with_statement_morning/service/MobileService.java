package com.qsp.jdbc_crud_with_statement_morning.service;

import java.util.List;

import com.qsp.jdbc_crud_with_statement_morning.dao.MobileDao;
import com.qsp.jdbc_crud_with_statement_morning.dto.Mobile;

public class MobileService {

	MobileDao dao = new MobileDao();
	// insert mobile----------------------------------------------------------------------------------
		public void insertMobile(Mobile mobile) {
			dao.insertMobile(mobile);
		}
		
	// update mobile------------------------------------------------------------------------------------
	public void  updateMobile(Mobile mobile) {
		dao.updateMobile(mobile);
	}	
	
	// delete mobile------------------------------------------------------------------------------------
	public void deleteMobile(int mobileId) {
		dao.deleteMobile(mobileId);
	}
	
	// display mobile----------------------------------------------------------------------------------
	public List<Mobile> displayMobile(){
		return dao.displayMobile();
	}
}
