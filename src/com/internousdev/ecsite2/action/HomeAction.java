package com.internousdev.ecsite2.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;

public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	
	@Override
	public String execute() {
		String result = "login";
		if(session.containsKey("login_user_id")) {
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			
			return SUCCESS;
			
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
	}
}
