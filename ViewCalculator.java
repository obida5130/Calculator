import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.io.*;
import java.net.*;

public class ViewCalculator {
    JFrame frame;
    JButton one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, times, divide;
    JLayeredPane layeredPane;
    ViewCalculator() {
        RoundButton one = new RoundButton("1");
        one.setSize(70, 30);
        one.setLocation(0, 630);
        one.setBackground(new Color(255, 255, 153));
        one.setFocusPainted(false);
        one.setActionCommand("receive");
        one.setEnabled(true);
        

        two = new JButton("2");
        two.setSize(120, 30);
        two.setLocation(320, 200);
        two.setBackground(new Color(255, 255, 153));
        two.setFocusPainted(false);
        two.setActionCommand("receive");
        two.setEnabled(true);
        
        three = new JButton("3");
        three.setSize(120, 30);
        three.setLocation(320, 200);
        three.setBackground(new Color(255, 255, 153));
        three.setFocusPainted(false);
        three.setActionCommand("receive");
        three.setEnabled(true);

        four = new JButton("4");
        four.setSize(120, 30);
        four.setLocation(320, 200);
        four.setBackground(new Color(255, 255, 153));
        four.setFocusPainted(false);
        four.setActionCommand("receive");
        four.setEnabled(true);

        five = new JButton("5");
        five.setSize(120, 30);
        five.setLocation(320, 200);
        five.setBackground(new Color(255, 255, 153));
        five.setFocusPainted(false);
        five.setActionCommand("receive");
        five.setEnabled(true);
        
        six = new JButton("6");
        six.setSize(120, 30);
        six.setLocation(320, 200);
        six.setBackground(new Color(255, 255, 153));
        six.setFocusPainted(false);
        six.setActionCommand("receive");
        six.setEnabled(true);

        seven = new JButton("7");
        seven.setSize(120, 30);
        seven.setLocation(320, 200);
        seven.setBackground(new Color(255, 255, 153));
        seven.setFocusPainted(false);
        seven.setActionCommand("receive");
        seven.setEnabled(true);

        eight = new JButton("8");
        eight.setSize(120, 30);
        eight.setLocation(320, 200);
        eight.setBackground(new Color(255, 255, 153));
        eight.setFocusPainted(false);
        eight.setActionCommand("receive");
        eight.setEnabled(true);

        nine = new JButton("9");
        nine.setSize(120, 30);
        nine.setLocation(320, 200);
        nine.setBackground(new Color(255, 255, 153));
        nine.setFocusPainted(false);
        nine.setActionCommand("receive");
        nine.setEnabled(true);

        zero = new JButton("0");
        zero.setSize(120, 30);
        zero.setLocation(320, 200);
        zero.setBackground(new Color(255, 255, 153));
        zero.setFocusPainted(false);
        zero.setActionCommand("receive");
        zero.setEnabled(true);






        
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

/**
 * this class to create round JButton for our calculator
 */
public class RoundButton extends JButton {
    private Shape button; // hold the shape of the button

    // Constructor RoundButton class
    public RoundButton(String label) {
        super(label); // Calls the constructor of the superclass JButton.

        // Adjusts the size of the button to be square, with side length equal to the longer of the preferred width and height.
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        setContentAreaFilled(false); // Sets the content area of the button to be transparent.
    }

    // Overriding the paintComponent method from JComponent to change how the button is drawn.
    protected void paintComponent(Graphics g) {
        // If the button is pressed, it sets the color to light gray, otherwise it uses the background color.
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }

        // Fills a rounded rectangle as the background of the button. The last two parameters are the horizontal and vertical diameter of the arc at the four corners.
        g.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, 20, 20);

        // Calls the superclass's paintComponent to draw the rest of the button (e.g., the label).
        super.paintComponent(g);
    }

    // Overriding the paintBorder method from JComponent to draw a border around the button.
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground()); // Sets the color to the button's foreground color.

        // Draws a rounded rectangle as the border of the button. The last two parameters are the horizontal and vertical diameter of the arc at the four corners.
        g.drawRoundRect(0, 0, getSize().width-1, getSize().height-1, 20, 20);
    }

    // Overriding the contains method from Component to change the area of the button that responds to clicks.
    public boolean contains(int x, int y) {
        // If the shape is null or its size doesn't match the current size of the button, it creates a new rounded rectangle.
        if (button == null || !button.getBounds().equals(getBounds())) {
            button = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20);
        }

        // Checks if the given point is inside the shape of the button.
        return button.contains(x, y);
    }
}
}
