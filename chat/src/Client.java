import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends JFrame implements ActionListener {
    Socket socket;
    JTextField  jTextField;
    Client() throws IOException {
        setLayout(new BorderLayout());
        socket = new Socket("127.0.0.1",5000);

        JPanel jPanel = new JPanel();
        jTextField = new JTextField("",10);

        jPanel.add(jTextField);

        JButton jButton = new JButton("send");
        jButton.addActionListener(this);
        jPanel.add(jButton);

        add(jPanel);
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws IOException {

        new Client();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(socket.getOutputStream());
            PrintWriter writer= new PrintWriter(outputStreamWriter);
            String txt = jTextField.getText();
            writer.println(txt);
            System.out.println(txt);
            writer.flush();
        } catch (UnknownHostException error) {
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
