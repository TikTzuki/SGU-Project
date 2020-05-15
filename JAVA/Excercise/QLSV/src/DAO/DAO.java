/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tik
 */
public class DAO {
    
    public static MyConnectUnit getDAO() {
         return new MyConnectUnit();
    }
    
}
