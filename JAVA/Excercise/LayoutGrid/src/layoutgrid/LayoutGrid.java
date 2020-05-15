/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutgrid;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Tik
 */
public class LayoutGrid extends JFrame {

    public LayoutGrid() {

        initComponents();
    }

    public final void initComponents() {

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        /* Trong phương thức khởi tạo GridLayout, 2 tham số đầu là số hàng và số cột, 
        hai tham số cuối là khoảng cách giữa các component theo chiều ngang và chiều dọc. */
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "Cls", "Bck", "", "Close",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (int i = 0; i < buttons.length; i++) {

            if (i == 2) {
                panel.add(new JLabel(buttons[i]));
            } else {
                panel.add(new JButton(buttons[i]));
            }
        }

        add(panel);

        setTitle("Layout Example");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                LayoutGrid ex = new LayoutGrid();
                ex.setVisible(true);
            }
        });
    }
}

