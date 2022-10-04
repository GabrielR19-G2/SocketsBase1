/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Piñuelas Ramos
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        final int puerto = 5500;
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado!");
//servidor atento a peticiones de clientes.
            while (true) {

                sc = servidor.accept(); //se quede a la espera.
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream()); //Para comunicarnos
                out = new DataOutputStream(sc.getOutputStream());

                String msg = in.readUTF(); //Se queda a la espera.

                System.out.println(msg);
                out.writeUTF("¡Hola mundo desde el servidor!");
                sc.close();//Cerrando el cliente
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
