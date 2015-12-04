import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.swing.SwingUtilities;

private ObjectOutputStream salida;
private ObjectInputStream entrada;
private ServerSocket servidor;
private Socket conexion;
private int contador = 1;

  public void ejecutarServidor(){
    try{
      servidor = new ServerSocket(12345, 100);
      while(true){
        try{
              esperarConexion();
              obtenerFlujos();
              procesarConexion();
      }catch(EOFException e){
        mostrarMensaje("\Servidor termino la conexion");
      }finally{
        cerrarConexion();
        contador++;
    }
    catch (IOException excepcionES){
      excepcionES.printStackTrace();
  }
  private void esperarConexion() throws IOException {
    mostrarMensaje("Esperando una conexion\n");
    conexion = servidor.accept();
    mostrarMensaje("Conexion " + contador + " recibida de: " + conexion.getInetAddress().getHostName());
  }
  private void obtenerFlujos() throws IOException{
    salida = new ObjectOutputStream(conexion.getOutputStream());
    salida.flush();
    entrada = new ObjectInputStream(conexion.getInputStream());
    mostrarMensaje("\nObtener flujos de E/S: OK\n");
  }
  private void enviarDatos(String mensaje){
    try{
      salida .writeObject("SERVIDOR dice: " + mensaje);
      salida.flush();
      mostrarMensaje("\nSERVIDOR dice: " + mensaje);
    }
    catch(IOException e){
      areaPantalla.append("\nERROR")
    }
  }
  private void procesarConexion() throws IOException{
    String mensaje ="Conexion Exitosa";
    enviarDatos(mensaje);
    campoIntroducir.setEnabled(true);
    do
    {
      try{
        mensaje = (String) entrada.readObject();
        mostrarMensaje("\n" + mensaje);
      }catch(ClassNotFoundException excepcion){
        mostrarMensaje("\nSe recibio un tipo de objeto desconocido")
      }
    }while (!mensaje.equals("CLIENTE dice: TERMINAR"));
  }
  private void cerrarConexion(){
    mostrarMensjae("\nTerminando Conexion\n");
    campoIntroducir.setEnabled(false);
    try{
      salida.close();
      entrada.close();
      conexion.close();
    }catch (IOException ioe){
      ioe.printStackTrace();
    }
  }
  public class IniciarServer{
    public
  }
  //continuara ... http://balusoft.net/2010/08/20/how-to-mini-chat-en%C2%A0java-clase-servidor/

private void mostrarMensaje(final String mensajeAMostrar){
  SwingUtilities.invokeLater(
      new Runnable(){
        public void run(){
          areaPantalla.append(mensajeAMostrar);
        }
      });
}
