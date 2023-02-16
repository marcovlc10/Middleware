package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import logica.Interpreter;

public class Cliente {
    
    private final int PORT = 5556;
    private final String HOST = "localhost";
    private Socket clientSocket;
    private DataOutputStream dos;
    private DataInputStream dis;
    
    public Cliente() throws IOException {
        clientSocket = new Socket(HOST, PORT);
    }
    
    public void sendMessage(String message) {
        
        try {
            
            Interpreter.convert(message);
            
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            
            pw.println(message);
            
            pw.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
