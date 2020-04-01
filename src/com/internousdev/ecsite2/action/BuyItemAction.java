package com.internousdev.ecsite2.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	
	private int count;
	private String pay;
	private Map<String,Object>session;
	
	@Override
	public String execute() {
		
		String result = SUCCESS;
		
		session.put("count", count);
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		
		session.put("total_price", count * intPrice);
		String payment;
		
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		}else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}
	
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
}
