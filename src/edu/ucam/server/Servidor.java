package edu.ucam.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static final int PORT = 2017;	//Puerto de conexión de capa de comandos
	private ArrayList<ServidorHilo> hilos = new ArrayList<ServidorHilo>(); //lista de hilos
	protected ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	
	public void ejecutar(){
		try {
			ServerSocket serverSocket = new ServerSocket(this.PORT);	//Socket del servidor que acepta las conexiones
			Socket socket;
			
			while(true) {
				//Nos ponemos a la escucha dentro del bucle para aceptar todas las peticiones posibles
				socket = serverSocket.accept();
				//Si recibimos una conexion, creamos un hilo nuevo.
				System.out.println("Conexión entrante de" + socket.getLocalAddress());
				ServidorHilo servidorHilo = new ServidorHilo(socket, this);
				servidorHilo.start();
				hilos.add(servidorHilo); //Y lo añadimos al array de hilos
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor servidor = new Servidor();
		servidor.ejecutar();
	}

}
