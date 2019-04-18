import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame implements ActionListener {
    JTextField resultTF;
    ArrayList<JButton> btns = new ArrayList<>();
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public Calculator(){
        setSize(400,500);
        setLayout(new BorderLayout());

        //결과 출력 textfield
        resultTF = new JTextField("",15);
        JPanel resultPanel =  new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        resultPanel.add(resultTF, gbc);

        //계산기 버튼
        JPanel btnPanel =  new JPanel();
        btnPanel.setLayout(new GridLayout(5,4,5,5));

        String[] btnValues = {"AC","+/-","%","/","7","8","9","X","4","5","6","-","1","2","3","+"," ","0",".","="};

        for (String val : btnValues){
            JButton btn = new JButton(String.valueOf(val));
            btn.addActionListener(this);
            btnPanel.add(btn);
            btns.add(btn);
        }

        add(resultPanel,BorderLayout.NORTH);
        add(btnPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
