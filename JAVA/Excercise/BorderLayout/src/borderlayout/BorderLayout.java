/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borderlayout;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Tik
 */
public class BorderLayout extends JFrame {
    public BorderLayout() {

        initComponents();
    }

    public final void initComponents() {

        // Create menu bar
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");

        menubar.add(file);
        setJMenuBar(menubar);

        // Create horizontal toolbar (NORTH)
        JToolBar horizontalToolbar = new JToolBar();
        horizontalToolbar.setFloatable(false);

        ImageIcon exitIcon = new ImageIcon("src/img/icons8_iris_scan_48px.png");
        JButton exitButton = new JButton(exitIcon);
        exitButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        horizontalToolbar.add(exitButton);

        add(horizontalToolbar, java.awt.BorderLayout.NORTH);

        // Create vertical toolbar (WEST)
        JToolBar verticalToolbar = new JToolBar(JToolBar.VERTICAL);
        verticalToolbar.setFloatable(false);
        verticalToolbar.setMargin(new Insets(10, 5, 5, 5));

        ImageIcon driveIcon = new ImageIcon("src/img/icons8_android_os_48px.png");
        ImageIcon computerIcon = new ImageIcon("src/img/icons8_linux_48px.png");
        ImageIcon printerIcon = new ImageIcon("src/img/icons8_windows8_48px.png");

        JButton driveButton = new JButton(driveIcon);
        driveButton.setBorder(new EmptyBorder(3, 0, 3, 0));

        JButton computerButton = new JButton(computerIcon);
        computerButton.setBorder(new EmptyBorder(3, 0, 3, 0));

        JButton printerButton = new JButton(printerIcon);
        printerButton.setBorder(new EmptyBorder(3, 0, 3, 0));

        verticalToolbar.add(driveButton);
        verticalToolbar.add(computerButton);
        verticalToolbar.add(printerButton);

        add(verticalToolbar, java.awt.BorderLayout.WEST);

        // Craete Text area (CENTER)
        add(new JTextArea(), java.awt.BorderLayout.CENTER);

        // Create Status bar (SOUTH)
        JLabel statusbar = new JLabel("Statusbar");
        statusbar.setPreferredSize(new Dimension(-1, 22));
        statusbar.setBorder(LineBorder.createGrayLineBorder());
        add(statusbar, java.awt.BorderLayout.SOUTH);

        setSize(350, 300);
        setTitle("Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                BorderLayout ex = new BorderLayout();
                ex.setVisible(true);
            }
        });
    }

}
