import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DrawCircle implements ActionListener {
    JFrame jFrame;
    int x = 70;
    int y = 70;

    public void go(){
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JButton jButton = new JButton();
//        jButton.addActionListener(this);

        MyDrawPanel myDrawPanel = new MyDrawPanel();

        jFrame.getContentPane().add(myDrawPanel);
//        jFrame.getContentPane().add(jButton,BorderLayout.SOUTH);

        jFrame.setSize(300, 300);
        jFrame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            try{
                jFrame.repaint();
                Thread.sleep(50);
            }catch (Exception e){}
        }

    }

    public void actionPerformed(ActionEvent e){
//        jFrame.repaint();
    }

    public static void main(String[] args) {
        DrawCircle dc = new DrawCircle();
        dc.go();
    }

    public class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.red);
            g.fillRect(0,0, this.getWidth(),this.getHeight());

            g.setColor(Color.orange);
            g.fillOval(x,y,100,100);
        }
    }

}
