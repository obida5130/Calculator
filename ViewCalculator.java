import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.io.*;
import java.net.*;

public class ViewCalculator {
    JFrame frame;
    JButton one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, times, divide;
    JLayeredPane layeredPane;
    ViewCalculator() {
        one = new JButton("1");
        one.setSize(120, 30);
        one.setLocation(320, 200);
        one.setBackground(new Color(255, 255, 153));
        one.setFocusPainted(false);
        one.setActionCommand("receive");
        one.setEnabled(true);





        
        // main layeredPane for frame
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(500, 700));
        layeredPane.add(one, Integer.valueOf(1));






























        // main frame for calculator
        final String TITLE = "Calculator";
        frame = new JFrame(TITLE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close application
        frame.setResizable(false);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 500;
        int height = 700;
        frame.setSize(width, height);
        frame.setLocation(center.x - width / 2, center.y - height / 2);
        Color frameBackground = new Color(55, 155, 153);
        frame.getContentPane().setBackground(frameBackground);
        frame.add(layeredPane, BorderLayout.CENTER);// add our layeredPane which has all the components
        frame.setVisible(true); // make window visible
        /************************************************************************************/
    }
}
