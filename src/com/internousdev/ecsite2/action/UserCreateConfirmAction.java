package com.internousdev.ecsite2.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object>session;
	private String errorMessage;
	
	@Override
	public String execute() {
		
		String result = SUCCESS;
		
		if(!(loginUserId.equals(""))&&!(loginPassword.equals(""))&&!(userName.equals(""))) {
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
		}else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}
	
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}