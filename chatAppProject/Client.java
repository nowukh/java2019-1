import java.awt.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ClientGui extends Thread {
    JFrame jFrame;
    // 접속 화면 컴포넌트
    JTextField portField;
    JTextField severAddrField;
    JButton connectBtn;

    // 채팅 화면 컴포넌트
    JButton sendBtn;
    JTextArea chatMsgArea;
    JTextArea userListArea;
    JTextField inputTextField;

    String serverAddr;
    int portNum;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    // make UI
    public ClientGui() {
        this.serverAddr = "localhost";
        this.portNum = 5000;

        jFrame = new JFrame();
        jFrame.getContentPane().setLayout(null);
        jFrame.setSize(700, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 채팅창
        chatMsgArea = new JTextArea();
        chatMsgArea.setBounds(25, 25, 490, 320);
        chatMsgArea.setLineWrap(true);
        chatMsgArea.setEditable(false);
        JScrollPane jtextFilDiscuSP = new JScrollPane(chatMsgArea);
        jtextFilDiscuSP.setBounds(25, 25, 490, 320);

        // 접속자 리스트
        userListArea = new JTextArea();
        userListArea.setBounds(520, 25, 156, 320);
        userListArea.setEditable(false);
        JScrollPane jsplistuser = new JScrollPane(userListArea);
        jsplistuser.setBounds(520, 25, 156, 320);

        // 채팅 메시지 작성 필드
        inputTextField = new JTextField();
        inputTextField.setBounds(0, 350, 400, 50);
        inputTextField.setMargin(new Insets(6, 6, 6, 6));
        inputTextField.setBounds(25, 350, 650, 50);

        // 전송 버튼
        sendBtn = new JButton("전송");
        sendBtn.setBounds(575, 410, 100, 35);
        sendBtn.addActionListener(e -> sendMessage());

        // 접속 화면
        portField = new JTextField(Integer.toString(this.portNum));
        severAddrField = new JTextField(this.serverAddr);
        connectBtn = new JButton("접속");

        severAddrField.setBounds(25, 380, 135, 40);
        portField.setBounds(200, 380, 135, 40);
        connectBtn.setBounds(575, 380, 100, 40);

        // 접속 화면 프레임에 추가
        jFrame.add(connectBtn);
        jFrame.add(jtextFilDiscuSP);
        jFrame.add(jsplistuser);
        jFrame.add(portField);
        jFrame.add(severAddrField);
        jFrame.setVisible(true);

        // 서버와 접속. setup networking
        connectBtn.addActionListener(e -> connectServer());

    }

    private void connectServer() {
        try {
            // 클라이언트 정보 가져옴
            String port = portField.getText();
            serverAddr = severAddrField.getText();
            portNum = Integer.parseInt(port);

            // 소켓 접속
            sock = new Socket(serverAddr, portNum);
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            writer = new PrintWriter(sock.getOutputStream(), true);

            // 메시지 받는 쓰레드 생성
            Thread readerThread = new Thread(new IncommingReader());
            readerThread.start();

            // 접속 후 채팅 화면으로 교체
            onConnectChangeFrame();

        } catch (Exception ex) {
        }
    }

    private void onConnectChangeFrame() {

        // 접속 페이지 제거
        jFrame.remove(portField);
        jFrame.remove(severAddrField);
        jFrame.remove(connectBtn);

        // 채팅 페이지 추가
        jFrame.add(sendBtn);
        jFrame.add(inputTextField);
        jFrame.revalidate();
        jFrame.repaint();
    }

    // 메시지 전송
    public void sendMessage() {
        try {
            // 보낼 메시지 가져옴
            String message = inputTextField.getText().trim();

            // 전송
            writer.println(message);
            inputTextField.setText(null);
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) throws Exception {
        ClientGui client = new ClientGui();
    }

    // 서버로부터 전송되는 메시지 읽는 runnable 객체
    class IncommingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    // 사용자 리스트가 전송됐을 경우
                    if (message.charAt(0) == '#') {
                        message = message.substring(2, message.length() - 1);
                        ArrayList<String> ListUser = new ArrayList<String>(Arrays.asList(message.split(", ")));
                        userListArea.setText(null);
                        for (String user : ListUser) {
                            addToTextArea(userListArea, user);
                        }
                        // 메시지가 전송됐을 경우
                    } else {
                        addToTextArea(chatMsgArea, message);
                    }
                }
            } catch (IOException ex) {
            }
        }
    }

    // 메시지 textarea에 추가
    void addToTextArea(JTextArea textArea, String msg) {
        textArea.append(msg + "\n");
    }
}
