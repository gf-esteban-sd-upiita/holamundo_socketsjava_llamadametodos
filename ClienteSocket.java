

import java.net.*;
import java.io.*;
import java.util.*;
public class ClienteSocket{
    public static void main(String[] args){

        int x, y, op;
        int resultado;

        try {
            System.out.print("[ Conectando con Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");

            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de salida de dados
            String msg = "Hola con Sockets!";
            byte[] buf = msg.getBytes(); // obteniendo la representación del byte del mensaje
            Scanner sc = new Scanner(System.in);

            System.out.print("[ Enviando mensaje    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");

            System.out.print("Ingrese la operación (1. Suma || 2. Multiplicación): ");
            /*String opr = sc.nextLine();              //reads string
            byte[] buf2 = opr.getBytes(); // obteniendo la representación del byte del mensaje
            os.write(buf2);*/
            op = sc.nextInt();
            //int buf1 = x.getInt(); // obteniendo la representación del byte del mensaje
            os.write(op);

            System.out.println("Escribe número x: ");
            x = sc.nextInt();
            //int buf1 = x.getInt(); // obteniendo la representación del byte del mensaje
            os.write(x);

            System.out.println("Escribe número y: ");
            y = sc.nextInt();
            //int buf2 = x.getBytes(); // obteniendo la representación del byte del mensaje
            os.write(y);

            resultado = is.read();
            System.out.println("Resultado: "+ resultado);


        }catch(Exception e){System.out.println(e);}
        System.out.println("[ Fin ]");
    }
}
