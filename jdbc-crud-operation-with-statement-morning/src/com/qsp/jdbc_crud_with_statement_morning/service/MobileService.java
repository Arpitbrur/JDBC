package com.qsp.jdbc_crud_with_statement_morning.service;

import com.qsp.jdbc_crud_with_statement_morning.dao.MobileDao;
import com.qsp.jdbc_crud_with_statement_morning.dto.Mobile;

public class MobileService {

	MobileDao dao = new MobileDao();
	// insert mobile----------------------------------------------------------------------------------
		public void insertMobile(Mobile mobile) {
			dao.insertMobile(mobile);
		}
}
