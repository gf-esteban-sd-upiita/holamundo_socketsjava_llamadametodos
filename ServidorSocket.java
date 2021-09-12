

import java.net.*;
import java.io.*;
public class ServidorSocket{

  static int suma(int x, int y) {
  return x+y;
}

  static int multiplicacion(int a, int b) {
  return a*b;
}

    public static void main(String[] args){

      int parametro1=0, parametro2=0, operacion=0;

        try {

            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");

            System.out.print("[ Esperando solicitudes de conexión ..................  ");
            Socket sock = ss.accept(); // Operación de bloqueo (esperando solicitud de conexión)
            System.out.println("[OK] ]");

            InputStream is = sock.getInputStream(); //Canal de entrada de datos
            OutputStream os = sock.getOutputStream(); //Canal de salida de datos
            byte[] buf = new byte[20]; // recibir búfer

            System.out.print("[ Esperando la recepción del mensaje  ..............  ");
            is.read(buf); // Operación de bloqueo (esperando la llegada de datos)
            System.out.println("[OK] ]");

            String msg = new String(buf); // Asignación de matriz(vector) de bytes recibidos a cadena

      /*      byte[] buf1 = new byte[20]; // recibir búfer
            is.read(buf1);
            String operacion = new String(buf1); // Asignación de matriz(vector) de bytes recibidos a cadena */
            //String buf1 = new String(buf1); // recibir búfer
            //operacion = is.read();

            operacion = is.read();
            parametro1 = is.read();//Integer.parseInt (in.readLine ( ));
            parametro2 = is.read();//Integer.parseInt (in.readLine ( ));

            System.out.println("  Mensaje recibido: "+ msg);
            System.out.println("  Operación recibida: "+ operacion);
            System.out.println("  Parámetro 1 recibido: "+ parametro1);
            System.out.println("  Parámetro 2 recibido: "+ parametro2);

            int resultado=0;

            if (operacion==1)
            {
              //final int parameter_value1 = Integer.parseInt(parametro1);
              //final int parameter_value2 = Integer.parseInt(parametro2);
              resultado = suma(parametro1, parametro2);
            }
            else if (operacion==2)
            {
              //final int parameter_value1 = Integer.parseInt(parametro1);
              //final int parameter_value2 = Integer.parseInt(parametro2);
              resultado = multiplicacion(parametro1, parametro2);
            }

            os.write(resultado);

        }catch(Exception e){System.out.println(e);}
        System.out.println("[ Fin ]");
    }
}
