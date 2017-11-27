package edu.ucam.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import edu.ucam.server.Servidor;

public class Cliente {
	private int contador=0;
	public void ejecutar() {
		try {
			Socket socket = new Socket("127.0.0.1", Servidor.PORT);
			Scanner teclado = new Scanner(System.in);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String mensaje;
			
			while(true)
			{
				mensaje = teclado.nextLine();
				pw.println(contador + " " + mensaje);
				pw.flush();
				contador++;
				System.out.println("[Server:]" + br.readLine());
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.ejecutar();
	}

}
