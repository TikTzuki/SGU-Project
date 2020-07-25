/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tik
 */
public class BUSRole {
    ConnectionUnit connect;

    public BUSRole() {
        connect = DAO.DAO.getDAO();
    }
    
    public String getRoleNameById(int roleId) throws Exception{
        ResultSet result = this.connect.Select("role", "role_id="+roleId);
        while(result.next()){
            return result.getString("role_name");
        }
        return "Không tìm thấy";
    }
    public ArrayList<String> getRoleName(){
        ArrayList<String> roleList = new ArrayList<>();
        try {
            ResultSet result = this.connect.Select("role");
            while(result.next()){
                roleList.add(result.getString("role_id")+". "+ result.getString("role_name"));
            }
        } catch (Exception ex) {
            Logger.getLogger(BUSRole.class.getName()).log(Level.SEVERE, null, ex);
        }
         return roleList;
    }
} 
