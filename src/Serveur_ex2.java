import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;

public class Serveur_ex2 {
    final static int PORT = 7878;


    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            OutputStream out = socket.getOutputStream();
            PrintWriter ostream = new PrintWriter(out);
            ostream.println("bienvenue mr le client ");
            ostream.println(LocalDateTime.now());

            ostream.flush();
            String msg;
            InputStream IS = socket.getInputStream();
            InputStreamReader ISR = new InputStreamReader(IS);
            BufferedReader reader = new BufferedReader(ISR);
            do {
                ostream.println("donner une phrase :");
                ostream.flush();
                msg = reader.readLine();
                ostream.println(msg.toUpperCase());
                ostream.flush();
            }
            while (!msg.equals("bye"));
            socket.close();
            serverSocket.close();
            ostream.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
