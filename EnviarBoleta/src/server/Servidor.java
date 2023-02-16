package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    private final int PORT = 5556;
    // private final String HOST = "localhost";
    private Socket cs;
    private ServerSocket ss;
    private DataOutputStream dos;
    private DataInputStream dis;
    
    public Servidor() throws IOException {
        ss = new ServerSocket(PORT); //Se crea el socket para el servidor en puerto 5555
        cs = new Socket(); //Socket para el cliente
    } //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        while (true) {
            try {
                System.out.println("Esperando..."); //Esperando conexión

                cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
                
                System.out.println("Cliente en línea");

                //Se obtiene el flujo de salida del cliente para enviarle mensajes
                dos = new DataOutputStream(cs.getOutputStream());

                //Se obtiene el flujo entrante desde el cliente
                String mensajeServidor;
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

                while ((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
                {
                    //Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                }

                // System.out.println("Fin de la conexión");

                // ss.close();//Se finaliza la conexión con el cliente
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
