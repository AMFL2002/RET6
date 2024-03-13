package retoUd6;

import java.io.Serializable;
import java.time.LocalTime;

public class Jugador <T>implements Serializable {
	public T nombre;
	public T arma;
	public T habitacion;
	public LocalTime horaPartida;
	
	public Jugador(T nombre, T arma,T habitacion,LocalTime horaPartida)
	{
		this.nombre=nombre;
		this.arma=arma;
		this.habitacion=habitacion;
		this.horaPartida=horaPartida;
	}

//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre){
//		this.nombre=nombre;
//	}
//	public String getArma() {
//		return arma;
//	}
//	public void setArma(String arma){
//		this.arma=arma;
//	}
//	public String getHabitacion() {
//		return habitacion;
//	}
//	public void setHabitacion(String habitacion){
//		this.habitacion=habitacion;
//	}
//	public LocalTime getHoraPartida() {
//		return horaPartida;
//	}
//	public void setHoraPartida(LocalTime horaPartida){
//		this.horaPartida=horaPartida;
//	}
	public String toString() {
		return "Jugador [nombre="+nombre+", arma="+arma+", habitación="+habitacion+", horaPartida="+horaPartida+"]";
	}
}
