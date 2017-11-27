package edu.ucam.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread {

	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private Servidor servidor;
	private String partes[];
	private String usuario;

	public ServidorHilo(Socket socket, Servidor servidor) throws IOException {
		this.socket = socket;
		this.servidor = servidor;
		this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		Alumno alumno1 = new Alumno();
		Alumno alumno2 = new Alumno();
		alumno2.nombre();
		servidor.alumnos.add(alumno1);
		servidor.alumnos.add(alumno2);
		System.out.println(servidor.alumnos.get(1).getNombre());
	}

	public void run() {
		String mensaje = " ";
		String respuesta = "";

		try {
			while (!mensaje.equalsIgnoreCase("EXIT")) {

				mensaje = br.readLine();
				System.out.println("Mensaje Nº:" + mensaje);
				respuesta = procesarMensaje(mensaje);
				pw.println(respuesta); // Mucho cuidado con poner 2 println
				pw.flush();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String procesarMensaje(String mensaje) {
		String resultado = " ";
		int i = 0;
		partes = mensaje.split(" "); // Separamos el mensaje por espacios

		switch (partes[1].toUpperCase()) {
		/*
		 * Es importante en este primer paso guardar el usuario si existe, ya que luego
		 * tendremos que comprobar su contraseña.
		 * */
		case ("USER"):
			while (i != servidor.alumnos.size()) {
				if (partes[2].equalsIgnoreCase(servidor.alumnos.get(i).getNombre())) {
					usuario = partes[2];
					return resultado = "Ok " + partes[0] + " envie contraseña.";
				}
				i++;
			}
			return resultado = "No hay usuario";
		// Fin de autenticacion de usuarios.

		case ("PASS"):
			while (i != servidor.alumnos.size()) {
				if (partes[2].equals(servidor.alumnos.get(i).getContraseña()) 
					&& servidor.alumnos.get(i).getNombre().equalsIgnoreCase(usuario))
				{
					usuario =" ";
					return resultado = "Contraseña correcta";
				}
				i++;
			}
		return resultado="Contraseña incorrecta. Vuelva a intentarlo";
		
		

		default:

			return resultado = "Comando no encontrado.";

		}

	}
}
