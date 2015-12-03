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
  public void esperarConexion() throws IOException {
    mostrarMensaje("Esperando una conexion\n");
    conexion = servidor.accept();
    mostrarMensaje("Conexion " + contador + " recibida de: " + conexion.getInetAddress().getHostName());
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
