package app;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
public class MyFrame extends JFrame{
    Panel p0 = new Panel();
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Label lb1 = new Label("Bai tap dau tien");
    JTextField tx1 = new JTextField("Hello world", 20);
    Button bt1 = new Button("Chao");

    public MyFrame(){
        setTitle("Ví dụ 1");
        setLayout(null);
        setSize(500, 500);
        Button buttOk = new Button("OK");
        
        buttOk.setBounds(100, 150, 50, 30);
        
        Button buttCancel = new Button("Cancel");
        
        buttCancel.setBounds(200, 150, 50, 30);
        
        Checkbox checkBut = new Checkbox("Checkbox", true);
        
        checkBut.setBounds(100, 50, 100, 20);
        
        List li = new List();
        
        for (int i=0; i<5; i++)
        
        {
        
        li.add(Integer.toString(i));
        
        }
        
        li.setBounds(200, 50, 50, 50);
        
        add(buttOk);
        
        add(buttCancel);
        

        
        add(checkBut);
        
        add(li);
        
        setBounds(10, 10, 400, 200);
        
/*
        setLayout(new GridLayout(3,1));
        p1.setBackground(Color.magenta);
        p2.setBackground(Color.MAGENTA);
        lb1.setAlignment(1);
        lb1.setForeground(Color.BLUE);
        lb1.setFont(new Font("Arial", Font.BOLD, 20));
        tx1.setFont(new Font("Arial", Font.BOLD, 20));
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tx1.setText("Hello worldddddd");
            }
        });
        p0.add(lb1);
        p1.add(tx1);
        p2.add(bt1);
        add(p0);
        add(p1);
        add(p2);*/
        setVisible(true);
    }
}