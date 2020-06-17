/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Tik
 */
public class DAO {
        public static ConnectionUnit getDAO() {
         return new ConnectionUnit();
    }
}
