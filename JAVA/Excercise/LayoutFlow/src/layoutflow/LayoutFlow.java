/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutflow;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Tik
 */
/*
FlowLayout();
FlowLayout(int align);
FlowLayout(int align, int hgap, int vgap);
Ở trên là 3 kiểu khởi tạo một FlowLayout, align quy định sắp xếp từ trái sang phải hay ngược lại, 
hgap là khoảng cách giữa các component theo chiều ngang, vgap là khảng cách giữa các component theo chiều dọc.
 */
public class LayoutFlow extends JFrame {

    public LayoutFlow() {

        initComponents();
    }

    public final void initComponents() {
        /* Mặc định khi tạo một JPanel thì layout được dùng sẽ là flowLayout luôn nên ở đây chúng ta không cần phải thiết lập lại */
        JPanel panel = new JPanel();
        
        /* Mặc định flowLayout sẽ thiết lập kích thước cho các component con vừa đủ để bao bọc nội dung bên trong component đó,
        nên nếu muốn có kích thước riêng thì chúng ta phải tự thiết lập lại bằng phương thức setPreferredSize().*/
        JTextArea area = new JTextArea("text area");
        area.setPreferredSize(new Dimension(100, 100));
        
        ImageIcon printerIcon = new ImageIcon("src/img/icons8_android_os_48px_1.png");
        JButton button = new JButton(printerIcon);
        panel.add(button);

        JTree tree = new JTree();
        panel.add(tree);

        panel.add(area);

        add(panel);

        pack();

        setTitle("Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                LayoutFlow ex = new LayoutFlow();
                ex.setVisible(true);
            }
        });
    }

}
