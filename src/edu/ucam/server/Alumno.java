package edu.ucam.server;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private int edad;
	private String contraseña;
	
	public Alumno(){
		this.nombre="Josema";
		this.apellido="Castañon";
		this.edad=22;
		this.contraseña="hola";
	}
	public void nombre() {
		this.nombre="Juande";
		this.apellido="Tortosa";
		this.edad=23;
		this.contraseña="adios";
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	public String getContraseña() {
		// TODO Auto-generated method stub
		return this.contraseña;
	}
}
