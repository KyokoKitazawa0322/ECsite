
package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class UserCreateCompleteDAO {

	public void createUser(String loginUserId, String loginUserPassword,String userName)throws SQLException {
		
		DateUtil dateutil = new DateUtil();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		
		String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date) VALUES(?,?,?,?)";		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, dateutil.getDate());
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally  {
				con.close();
		}
	}
}


