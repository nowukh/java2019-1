import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame implements ActionListener {
    JTextField resultTF;
    ArrayList<JButton> btns = new ArrayList<>();

    String xx = ""; // 계산식의 첫번째 인자
    String yy = ""; // 두번째 인자
    String operator = ""; //연산자 저장

    public Calculator(){
        setLayout(new BorderLayout()); //최상위 프레임에 border layout 설정
        setBackground(Color.white);

        //결과 출력 textfield 레이아웃 설정
        resultTF = new JTextField("0",15);
        resultTF.setFont(new Font("돋움", Font.PLAIN, 60));
        resultTF.setFocusable(false);
        resultTF.setBorder(null);
        resultTF.setHorizontalAlignment(JTextField.RIGHT);

        // 패널에 추가
        JPanel resultPanel =  new JPanel(new GridLayout(1,1));
        resultPanel.add(resultTF);

        //계산기 버튼 레이아웃 설정
        JPanel btnPanel =  new JPanel();
        btnPanel.setLayout(new GridLayout(5,4,0,0));

        // 버튼 생성 및 패널에 추가
        String[] btnValues = {"AC","+/-","%","/","7","8","9","X","4","5","6","-","1","2","3","+"," ","0",".","="};

        for (int i = 0; i < btnValues.length; i++){
            String val = btnValues[i];

            //버튼은 버튼 색 변경을 위해 JButton을 상속받은 CalcBtn 클래스를 이용
            CalcBtn btn = new CalcBtn(val);

            btn.setForeground(Color.white);
            btn.setBorder(null);
            btn.setFont(new Font("돋움", Font.PLAIN, 30));

            if(i < 3){ // AC, +-, % 색 변경
                btn.setBackground(new Color(64, 62, 63));
                btn.setPressedBackgroundColor(new Color(160,160,160));
            }
            else if(i % 4 == 3){ // 연산자 색 변경
                btn.setBackground(new Color(243, 162, 60));
                btn.setPressedBackgroundColor(new Color(193,128,45));
            }
            else{ //키패드 색 변경
                btn.setBackground(new Color(95, 95, 95));
                btn.setPressedBackgroundColor(new Color(160,160,160));
            }


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

    @Override
    public void actionPerformed(ActionEvent e) {

        String input = e.getActionCommand();
        switch (input){
            case("AC"): // 저장된 값들 초기화
                resultTF.setText("0");
                xx = "";
                yy = "";
                operator = "";
                break;

            case("+/-"): //양수, 음수 부호 바꾸는 기능
                if (yy.equals("")){ // 첫번째 숫자의 부호를 바꾸는 경우
                    xx = xx.substring(0,1).equals("-") ? xx.substring(1) : "-"+xx; //부호 확인 후 변경
                    resultTF.setText(xx +"");
                }else{ // 두번째 숫자 부호 바꿈
                    yy = yy.substring(0,1).equals("-") ? yy.substring(1) : "-" + yy; // 부호 확인 후 변경
                    resultTF.setText(yy +"");
                }
                break;
            case("%"): //숫자를 백분율로 변환. 100으로 나눠주면 된다.
                if (yy.equals("")){ // 첫번째 숫자 변환
                    xx = (Double.parseDouble(xx) / 100) + "";
                    resultTF.setText(xx);
                }else{ // 두번째 숫자 변환
                    yy = (Double.parseDouble(yy) / 100) + "";
                    resultTF.setText(yy);
                }

                break;

            case("+"):
            case("-"):
            case("X"):
            case("/"):
                operator = input; //연산자를 저장하고 끝낸다.
                break;

            case("="):
                calc();

                break;
            default: // 첫번째 인자 입력중인 경우
                if (operator.equals("")){ //연산 전 숫자만 입력할 때
                    xx += input;
                    resultTF.setText(xx);
                }else{ // 두번째 인자 입력중
                    yy += input;
                    resultTF.setText(yy);
                }

                break;

        }
        System.out.println(xx + operator + yy); //테스트용
    }

    private void calc() { //연산 후 출력하는 메소드
        double x = Double.valueOf(xx);
        double y = Double.valueOf(yy);

        switch (operator){
            case("+"):
                x += y;
                break;
            case("-"):
                x -= y;
                break;
            case("/"):
                x /= y;
                break;
            case("X"):
                x *= y;
                break;
            default: // =일 경우, 연산자 없을 경우

                break;
        }
// 소수점이 있는지 확인해, 없으면 정수만 출력
        xx = (x - (int)x == 0.0) ? (int)x + "" : x+"";
        yy = "";
        operator = "";
        resultTF.setText(xx);
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
