package retoUd6;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class cluedo {
	public static void main(String[] args) throws IOException {
 String[] arrayNombre=new String[] {"Amapola","Celeste","Prado","Mora","Rubio","Blanco"};
 String[] arrayArma=new String[] {"bate","pistola","candelabro","cuchillo","cuerda","hacha","pesa","veneno","trofeo"};
 String[] arrayHab=new String[] {"casa de invitados","teatro","spa","observatorio","comedor","terraza","salon","cocina","vestíbulo"};
 
 System.out.println("Bienvenid@ al programa encargado de barajar las cartas de forma aleatorias del juego Cluedo.");
 System.out.println("");
 System.out.println("Se le muestran los personasjes disponibles:");
 System.out.println("-------------------------------------------");
 	for(int i=0;i<=(arrayNombre.length-1);i++)
 		{
 		System.out.println(arrayNombre[i]);
 		}
 System.out.println("");
 System.out.println("Se le muestran las armas disponibles:");
 System.out.println("-------------------------------------------");
 	for(int i=0;i<=(arrayArma.length-1);i++)
 {
	 System.out.println(arrayArma[i]);
 }
 	System.out.println("");
 System.out.println("Se le muestran las habitaciones disponibles:");
 System.out.println("-------------------------------------------");
 for(int i=0;i<=(arrayHab.length-1);i++)
 {
	 System.out.println(arrayHab[i]);
 }
 System.out.println("");
 int respuesta=0;
 
 do {
		 System.out.println("¿Quiere añadir algo más?");
		 System.out.println("");
		 System.out.println("Menú para más información");
		 System.out.println("1.Personaje.");
		 System.out.println("2.Arma.");
		 System.out.println("3.Habitación.");
		 System.out.println("4.Salir.");
		 System.out.println("Opción:");
		 Scanner in=new Scanner(System.in);
		 respuesta=in.nextInt();
 
 while(respuesta<=0 || respuesta>4) {
	 System.out.println("Numero incorrecto, introduzca otro:");
	 respuesta=in.nextInt();
 }
 int num;
 switch(respuesta)
 {
 case 1:{
	 System.out.println("¿Cuántos personajes quieres añadir?");
	 num=in.nextInt();
	 arrayNombre=actualizarArray(arrayNombre, num);
	 in.nextLine();
	 for(int i=arrayNombre.length-num;i<arrayNombre.length;i++)
	 {
		 System.out.println("\nIntroduce nombre del personaje: ");
		 String introdato=in.nextLine();
		 arrayNombre[i]=introdato;
		 
	 }
	 System.out.println("\nArray personajes actualizado: "+Arrays.toString(arrayNombre));
	 break;
 }
 case 2:{
	 System.out.println("¿Cuántas armas quieres añadir?");
	 num=in.nextInt();
	 arrayArma=actualizarArray(arrayArma, num);
	 in.nextLine();
	 for(int i=arrayArma.length-num;i<arrayArma.length;i++)
	 {
		 System.out.println("\nIntroduce nombre del arma: ");
		 String introdato=in.nextLine();
		 arrayArma[i]=introdato;
	 }
	 System.out.println("Array armas actualizado: "+Arrays.toString(arrayArma));
	 break;
 }
 case 3:{
	 System.out.println("¿Cuántas habitaciones quieres añadir?");
	 num=in.nextInt();
	 arrayHab=actualizarArray(arrayHab, num);
	 in.nextLine();
	 for(int i=arrayHab.length-num;i<arrayHab.length;i++)
	 {
		 System.out.println("\nIntroduce nombre de la habitación: ");
		 String introdato=in.nextLine();
		 arrayHab[i]=introdato;
	 }
	 System.out.println("Array habitaciones actualizado: "+Arrays.toString(arrayHab));
	 break;
 }
 case 4:{
	 System.out.println("¡Genial, sigamos...!");
	 break;
 }
	 
 }
 }
 while(respuesta!=4);
	

LinkedList<Jugador<String>> jugadoresTotal=new LinkedList<Jugador<String>>();
String continuar="";
do {
boolean barajarlo=barajar(arrayNombre, arrayArma, arrayHab,jugadoresTotal);

if(barajarlo){
	System.out.println("***Baraja de cartas realizada con éxito***");
	System.out.println("Si introduces la clave correcta te puedo mostrar quien ha sido el culpable, como y donde...");
	Scanner cl=new Scanner(System.in);
	String clave=cl.nextLine();
		if(clave.equals("1234")) {
			System.out.println("***Cartas ganadoras***");
			System.out.print("Último elemento: ");
			int ultimo=jugadoresTotal.size()-1;
			System.out.println(jugadoresTotal.get(ultimo));
			
			System.out.println("¿Quieres crear una nueva combinación para el juego(s para continuar)?");
			continuar=cl.nextLine();
			}
		else {
		System.out.println("No tienes permiso para verlas");
		System.out.println("¿Quieres crear una nueva combinación para el juego(s para continuar)?");
		continuar=cl.nextLine();
	}
	

}
else {
	System.out.println("***No se ha podido barajar***");
}

}
while(continuar.equals("s"));
fichero(jugadoresTotal);

 
 
	}
	public static void fichero(LinkedList <Jugador<String>> lista) throws IOException {
		String directorio=System.getProperty("user.dir");
		String rutaString=directorio+File.separator+"Combinaciones.txt";
		BufferedWriter f=new BufferedWriter(new FileWriter(rutaString,true));
		Jugador<String> auxJugador;
		for(int i=0;i<=lista.size()-1;i++)
		{
			auxJugador=lista.get(i);
			f.write("Cabecera - Fecha: " +LocalDate.now()+"\n");
			f.write(auxJugador+"\n");

		}
		f.close();
		
	}
	public static String[] actualizarArray(String[] arrayAntiguo,int num) {
		String[] arrayNuevo=new String[arrayAntiguo.length+num];
		System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);
		return arrayNuevo;
	}
	public static boolean barajar(String[] arraynom,String[] arrayarm,String[] arrayhabi, LinkedList <Jugador<String>>jugadores) {
		try {
			int non=(int) (Math.random()*arraynom.length);
			int arm=(int) (Math.random()*arrayarm.length);
			int hab=(int) (Math.random()*arrayhabi.length);
			System.out.println("...Barajando cartas...");
			System.out.println(non);
			System.out.println(arm);
			System.out.println(hab);
			LocalTime horaLocalTime=LocalTime.now();
			jugadores.add(new Jugador<String>(arraynom[non], arrayarm[arm], arrayhabi[hab], horaLocalTime));
			
			return true;
		} catch (Exception e) {
			return false;	
			}
		

	}

}
