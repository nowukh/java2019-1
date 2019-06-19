import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  ArrayList<PrintWriter> clientOutputStreams;
  ArrayList<String> connectedClients;
  static int numOfClient = 1;

  public static void main(String[] args) {
    new Server().go();
  }

  public void go() {
    clientOutputStreams = new ArrayList();
    connectedClients = new ArrayList();

    try {
      ServerSocket serverSock = new ServerSocket(5000);
      while (true) {
        // 클라이언트 연결
        Socket clientSocket = serverSock.accept();

        // 클라이언트 ouputstream 저장
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        clientOutputStreams.add(writer);

        // 클라이언트 쓰레드 시작
        Thread t = new Thread(new ClientHandler(clientSocket));
        t.start();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void broadcastMsg(String message) {
    for (PrintWriter writer : clientOutputStreams) {
      writer.println(message);
    }
  }

  public class ClientHandler implements Runnable {
    BufferedReader reader;
    Socket sock;
    String clientName;

    public ClientHandler(Socket clientSocket) {
      try {
        clientName = "사용자" + Integer.toString(numOfClient++);
        sock = clientSocket;

        // 사용자 메시지 받을 reader 세팅
        InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
        reader = new BufferedReader(isReader);
        broadcastMsg(clientName + " 님이 입장하셨습니다.");

        // 사용자 리스트에 추가하고, 사용자들에게 리스트 갱신하게 함
        connectedClients.add(clientName);
        sendClientList();

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    private void sendClientList() {
      // 사용자 리스트는 #으로 시작하는 메시지
      broadcastMsg("#" + connectedClients);
    }

    public void run() {
      String message;
      try {
        while ((message = reader.readLine()) != null) {
          broadcastMsg(clientName + ": " + message);
        }
        closeSocket();
      } catch (Exception ex) {
        closeSocket();
      }
    }

    void closeSocket() {
      try {
        reader.close();
        sock.close();

        broadcastMsg(clientName + " 님이 퇴장하셨습니다.");

        // 사용자 리스트에서 삭제 후 사용자 리스트 다시 전송
        connectedClients.remove(clientName);
        sendClientList();
      } catch (Exception e) {
      }
    }
  }
}
