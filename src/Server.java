import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final static  int PORT = 7878;
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("J'attends la connexion d'un client");
        Socket socket = serverSocket.accept();
        System.out.println("Un client st connecte, son IP est:" + socket.getInetAddress());
        try {
            InputStream IS = socket.getInputStream();
            InputStreamReader ISR = new InputStreamReader(IS);
            BufferedReader reader = new BufferedReader(ISR);
            String request = reader.readLine();
            System.out.println("Le client a envoye le message:" + request);
            OutputStream OS = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(OS);
            writer.println("Bonjour Mr le client");
            writer.flush();
            reader.close();
            writer.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
