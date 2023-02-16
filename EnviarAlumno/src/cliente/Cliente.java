package cliente;

import entidades.Alumno;
import java.io.DataInputStream;
import logica.JsonPacket;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    
    private final int PORT = 5555;
    private final String HOST = "localhost";
    private Socket clientSocket;
    private DataOutputStream dos;
    private DataInputStream dis;
    
    public Cliente() throws IOException {
        clientSocket = new Socket(HOST, PORT);
    }
    
    public void sendMessage(Alumno alm) {
        
        String message = JsonPacket.toJson(alm);
        
        try {
            
            System.out.println(message);
            
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            
            pw.println(message);
            
            pw.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
