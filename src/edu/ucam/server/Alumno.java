package edu.ucam.server;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private int edad;
	private String contrase�a;
	
	public Alumno(){
		this.nombre="Josema";
		this.apellido="Casta�on";
		this.edad=22;
		this.contrase�a="hola";
	}
	public void nombre() {
		this.nombre="Juande";
		this.apellido="Tortosa";
		this.edad=23;
		this.contrase�a="adios";
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	public String getContrase�a() {
		// TODO Auto-generated method stub
		return this.contrase�a;
	}
}
