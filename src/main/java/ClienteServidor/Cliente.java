package ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Piñuelas 3 oct 22
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final String Host = "127.0.0.1";
        final int puerto = 5500;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(Host, puerto);
            in = new DataInputStream(sc.getInputStream()); //Para comunicarnos
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("¡Hola mundo desde el cliente!");
            String mensaje = in.readUTF();
            System.out.println(mensaje);

            sc.close();

        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
