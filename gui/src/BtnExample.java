import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BtnExample implements ActionListener {
//    JLabel label = new JLabel("");
    JButton[] btns = new JButton[4];

    public void go(String title){

        JFrame frame = new JFrame(title);
        // 그리드 레이아웃 설정
        frame.setLayout(new GridLayout(3,3));
        Container container = frame.getContentPane();

        // 그리드에 버튼 배치
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(i + " button");
            btns[i].addActionListener(this);
            container.add(btns[i]);
        }

        frame.setSize(500,500);

        // 종료 버튼 설정 및 packing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 이벤트 발생시킨 버튼
        JButton eventBtn =(JButton)e.getSource();
        System.out.println(((JButton) e.getSource()).getActionCommand());

        //이벤트 발생시킨 버튼에 배경색
        for (JButton btn: btns) {
            if (btn.equals(eventBtn)){
                btn.setBackground(Color.green);
                btn.setOpaque(true);
            }else{
                btn.setBackground(Color.white);
            }
        }

    }

    public static void main(String[] args) {
        new BtnExample().go("this is title");
    }
}
