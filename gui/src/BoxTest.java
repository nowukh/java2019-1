import javax.swing.*;
import java.awt.*;

public class BoxTest {

    public static void main (String[] args) {
        BoxTest gui = new BoxTest();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JTextField jTextField = new JTextField("your name", 20);
        jTextField.requestFocus();
        panel2.add(jTextField);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.darkGray);

        JButton button = new JButton("Button one");
        JButton buttonTwo = new JButton("Button 2");
        button.addActionListener(e ->{
            System.out.println(jTextField.getText());
            jTextField.selectAll();

        });
        JTextArea txt = new JTextArea(3,20);
        JScrollPane scroller = new JScrollPane(txt);
        txt.setLineWrap(true);




        panel.add(button);
        panel.add(buttonTwo);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.getContentPane().add(BorderLayout.WEST, panel2);
        frame.getContentPane().add(BorderLayout.SOUTH, scroller);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,500);
        frame.setVisible(true);
} }