/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nulllayout;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Tik
 */
public class Frame extends JFrame {

    public Frame() {
        initComponents();
    }

    void initComponents() {
        JFrame frame = new JFrame();

        frame.setLayout(null);
        frame.setSize(500, 400);

        JPanel bg = new JPanel();
        frame.add(bg);
        bg.setLayout(null);
        bg.setBounds(0, 0, 500, 400);

        JPanel inforStudent = addInforStudentComp(0, 0, 500, 300);
        bg.add(inforStudent);

        JPanel manager = addManagerComp(0, inforStudent.getHeight(), 500, 100);
        bg.add(manager);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        pack();
    }

    JPanel addInforStudentComp(int x, int y, int width, int height) {
        JPanel pnlNull = new JPanel(null);
        pnlNull.setBounds(x, y, width, height);
        pnlNull.setBackground(new Color(229, 218, 218));

        String labelContent[] = {"MSSV", "Tên đầy đủ", "Ngày sinh", "Giới tính", "Dân tộc"};
        JLabel lbl[] = new JLabel[labelContent.length];
        JTextField txt[] = new JTextField[labelContent.length];
        int i = 0;
        for (String s : labelContent) {
            lbl[i] = new JLabel(s);
            lbl[i].setBounds(x + 20, y + 20, 100, 24);
            lbl[i].setFont(new Font("Dialog", 1, 14));
            pnlNull.add(lbl[i]);

            txt[i] = new JTextField();
            txt[i].setBounds(x + 120, y + 20, 200, 24);
            txt[i].setFont(new Font("Dialog", 0, 14));
            pnlNull.add(txt[i]);

            y += 50;
        }
        return pnlNull;
    }

    JPanel addManagerComp(int x, int y, int width, int height) {
        JPanel pnlFlow = new JPanel();
        pnlFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        pnlFlow.setBounds(x, y, width, height);
        pnlFlow.setBackground(new Color(0, 38, 66));

        String buttonName[] = {"Thêm", "Sửa", "Xóa"};
        JButton btn[] = new JButton[buttonName.length];
        int i = 0;
        for (String s : buttonName) {
            btn[i] = new JButton(s);
            pnlFlow.add(btn[i]);
        }
        return pnlFlow;
    }
}
