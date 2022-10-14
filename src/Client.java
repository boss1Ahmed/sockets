import java.io.*;
import java.net.Socket;

public class Client {
    final static int PORT = 7878;
    final static String HOST = "localhost";
    public static void main(String args[]) throws Exception {
        try{
            Socket socket = new Socket(HOST,PORT);
            System.out.println("j'ai envoyé la requete de connexion via le port N° " + socket.getLocalPort());
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            String requete = "bonjour mr le serveur ";
            writer.println(requete);
            writer.flush();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String response = reader.readLine();
            System.out.println("Le serveur m'a repondu par le message " + response);
            writer.close();
            reader.close();
            socket.close();
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}
