/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Tik
 */
public class mainFrame {
    public mainFrame(){
        initComp();
    }
    public void initComp(){
        JFrame frame = new JFrame("Tik's app");
        frame.setLayout(null);
        frame.setSize(500, 400);
        
        JPanel pnlTbl = initTable();
        
        frame.add(pnlTbl);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public JPanel initTable(){
        JPanel bg = new JPanel(null);
        bg.setBounds(0, 0, 500, 400);
        
        String[] columnName = {"Dsa","DSAD","dsad"};
        Object[][] data = {
            {"dasd","dsad","dasd"},
            {"dasd","dsad","dasd"},
            {"dasd","dsad","dasd"},
            {"dasd","dsad","dasd"},
        };
        JTable tbl = new JTable(data, columnName);
        //tbl.setBounds(0, 0, 500, 400);
        tbl.setPreferredSize(new Dimension(0,1000));
        tbl.getColumnModel().getColumn(0).setPreferredWidth(200);
        JScrollPane scroll = new JScrollPane(tbl);
        //scroll.setViewportView(tbl);
        scroll.setBounds(0, 0, 500, 200);
        bg.add(scroll);
        return bg;
    }
    
}
