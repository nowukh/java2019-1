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

        setLayout(new BorderLayout());

        //결과 출력 textfield 레이아웃 설정
        resultTF = new JTextField("",15);
        JPanel resultPanel =  new JPanel(new GridLayout(1,1));
        resultPanel.add(resultTF);

        //계산기 버튼 레이아웃 설정
        JPanel btnPanel =  new JPanel();
        btnPanel.setLayout(new GridLayout(5,4,5,5));

        // 버튼 생성 및 패널에 추가
        String[] btnValues = {"AC","+/-","%","/","7","8","9","X","4","5","6","-","1","2","3","+"," ","0",".","="};

        for (String val : btnValues){
            JButton btn = new JButton(String.valueOf(val));
            btn.addActionListener(this);
            btnPanel.add(btn);
            btns.add(btn);
        }

        // 컨테이너에 패널 추가
        add(resultPanel,BorderLayout.NORTH);
        add(btnPanel);

        //window 관련 설정
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
