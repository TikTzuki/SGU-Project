/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tik
 */
public class ConnectionUnit {
    private MysqlConnection connect;
    

    public ConnectionUnit(String host, String user, String pass, String database) {
        connect = new MysqlConnection(host, user, pass, database);
    }
    
    public ConnectionUnit()  {
        connect = new MysqlConnection("localhost", "root", "", "book_store");
    }
    
    //SELECT * FROM TableName WHERE Condition ORDER BY OrderBy;
    public ResultSet Select(String table, String Condition, String OrderBy) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM " + table+"");
        this.AddCondition(query, Condition);
        this.AddOrderBy(query, OrderBy);
        query.append(";");
        System.out.println("Select: " + query.toString());
        return this.connect.executeQuery(query.toString());
    }

    public ResultSet Select(String table, String Condition) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM " + table+"");
        this.AddCondition(query, Condition);
        query.append(";");
        System.out.println("Select: " + query.toString());
        return this.connect.executeQuery(query.toString());
    }

    public ResultSet Select(String table) throws Exception{
        StringBuilder query = new StringBuilder("SELECT * FROM " + table+"");
        query.append(";");
        System.out.println("Select: " + query.toString());
        return this.connect.executeQuery(query.toString());
    }
    
    public ResultSet execute(String query) throws Exception {
        return this.connect.executeQuery(query);
    }
    private void AddCondition(StringBuilder query, String Condition) {
        if (Condition != null) {
            query.append(" WHERE " + Condition);
        }
    }

    private void AddOrderBy(StringBuilder query, String OrderBy) {
        if (OrderBy != null) {
            query.append(" ORDER BY " + OrderBy);
        }
    }

    //INSERT INTO TableName (columnName...) VALUES (column Value)
    public boolean Insert(String TableName, HashMap<String, Object> ColumnValues) throws Exception{
        System.out.println(TableName);
        StringBuilder query = new StringBuilder("INSERT INTO " + TableName+"");
        StringBuilder valueInsert = new StringBuilder();
        query.append("(");
        //Duyệt và đưa thông tin tên cột và giá trị của cột vào
        for (String key : ColumnValues.keySet()) {
            query.append(key + ",");
            valueInsert.append("'" + ColumnValues.get(key).toString() + "' ,");
        }
        //Cắt ký tự "," cuối câu
        query = query.delete(query.length() - 1, query.length());
        valueInsert = valueInsert.delete(valueInsert.length() - 1, valueInsert.length());
        //Đưa giá trị của cột vào câu query
        query.append(") VALUES(" + valueInsert.toString() + ")");
        query.append(";");
        System.out.println("Insert: " + query.toString());
        return this.connect.executeUpdate(query.toString()) > 0;
    }

    //UPDATE TableName SET ColumnName = ColumnValue WHERE 
    public boolean Update(String TableName, HashMap<String, Object> ColumnValues, String Condition) throws Exception{
        StringBuilder query = new StringBuilder("UPDATE " + TableName + " SET ");
        //Duyệt và đưa thông tin tên cột và giá trị của cột vào câu query
        for (String key : ColumnValues.keySet()) {
            query.append(key + " = '" + ColumnValues.get(key).toString() + "',");
        }
        //Cắt ký tự ',' cuối câu
        query = query.delete(query.length() - 1, query.length());
        //Đưa câu lệnh điều kiện vào trong câu query
        this.AddCondition(query, Condition);
        //Chèn ký tự ';' vào cuối dòng
        query.append(";");
        System.out.println("Update: " + query.toString());
        return this.connect.executeUpdate(query.toString()) > 0;
    }

    public boolean Delete(String TableName, String Condition) throws Exception{
        StringBuilder query = new StringBuilder("DELETE FROM " + TableName+"");
        this.AddCondition(query, Condition);
        query.append(";");
        System.out.println("Delete: " + query.toString());
        return this.connect.executeUpdate(query.toString()) > 0;
    }

    public static int getColumnCount(ResultSet result) throws SQLException{
            return result.getMetaData().getColumnCount();
    }

    public static String[] getColumnName(ResultSet result) throws SQLException {
        ResultSetMetaData rsMetaData = (ResultSetMetaData) result.getMetaData();
        //Lấy số lượng cột trong Result
        int ColumnCount = rsMetaData.getColumnCount();
        //Khai báo danh sách các cột
        String[] list = new String[ColumnCount];
        //Duyệt các cột
        for (int i = 0; i < ColumnCount; i++) //lấy tên đưa vào danh sách
        {
            list[i] = rsMetaData.getColumnName(i);
        }
        return list;
    }

    public void Close() throws SQLException{
        connect.Close();
    }
}
