
package com.groupc.saleberry.Dao;

import com.groupc.saleberry.Database.MySqlConnection;
import com.groupc.saleberry.Model.LoginModel;
import com.groupc.saleberry.Model.RegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDao extends MySqlConnection{
    public boolean register(RegisterModel user){
        try{
            PreparedStatement ps =null;
            Connection conn = openConnection();
            String sql = "INSERT INTO user(first_name,last_name,user_id,contact_no,password,confirm_password) VALUES(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getUserId());
            ps.setString(4, user.getContact_no());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getConfirm_password());
            
            int result = ps.executeUpdate();
            if(result == -1){
                return false;
            }else{
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public RegisterModel Login(LoginModel login){
        try{
          PreparedStatement ps=null;
          Connection conn=openConnection();
          String sql="SELECT * FROM user WHERE user_id=? and password=?";
          ps=conn.prepareStatement(sql);
          ps.setString(1,login.getUserId());
          ps.setString(2,login.getPassword());

          ResultSet result=ps.executeQuery();
          if(result!=null && result.next()!=false){
                String userId=result.getString("user_id");
                String password=result.getString("password");
                String firstName=result.getString("first_name");
                String lastName=result.getString("last_name");
                String contact=result.getString("contact_no");
                String passwordConfirm=result.getString("confirm_password");
                RegisterModel user=new RegisterModel(userId,password,firstName,lastName,contact,passwordConfirm);
                return user;
          }else{ 
                return null;
          }
         }catch (Exception exception){
            System.out.println("Database error");
    }
        return null;
        
}   
}



 
