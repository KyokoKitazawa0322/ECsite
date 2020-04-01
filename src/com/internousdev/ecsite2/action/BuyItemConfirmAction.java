package com.internousdev.ecsite2.action;

import java.util.Map;
import java.sql.SQLException;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object>session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO(); 
	
	@Override
	public String execute() throws SQLException{
		/*object型でputしているため、tostringでString型に変換*/
		buyItemCompleteDAO.buyItemInfo(
			
			/*LoginActionでputした値*/
			session.get("id").toString(),//商品のId
			session.get("login_user_id").toString(),
			
			/*BuyItemActionでputした値*/
			session.get("total_price").toString(),
			session.get("count").toString(),
			session.get("pay").toString());
		
		String result = SUCCESS;
		return result;
	}
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
