package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.Controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*El usuario debe poder registrar hasta 10 proyectos. 
En Green al aceptar un proyecto de un cliente se debe registrar el
 mismo almacenando la siguiente información: nombre del proyecto, nombre del cliente, 
 tipo de proyecto (puede ser Desarrollo, Mantenimiento, Despliegue), fecha planeada para el 
 inicio del proyecto y fecha planeada para la finalización del proyecto, el valor correspondiente 
 al presupuesto del proyecto.
 */
public class Main{

	private Scanner input;
	private Controller controller;
	private SimpleDateFormat simpleDateFormat;

	public Main() {

		input = new Scanner(System.in);
		controller = new Controller();
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	public static void main(String[] args) {

		Main view = new Main();
		int option = 0;
		do{
			view.menu();
			option = view.input.nextInt();
			view.executeOption(option);
		}while(option!=0);
		
		view.input.close();
	}

	// Incomplete
	public void menu() {
		System.out.println("0.Exit");
		System.out.println("1 RegisterProject.");
		System.out.println("2. search Projects After Date");
		System.out.println("3. search Projects Before Date");
		

	}

	public void executeOption(int option){
		switch(option){
			case 0:
			System.out.println("Exit");
				break;
			case 1:
				RegisterProject();
				break;
			case 2:
				searchProjectsAfterDate();
				break;
			case 3:
				searchProjectsBeforeDate();
				break;
		}

	}
	//Incomplete
	public void RegisterProject() {
		String name = "";
		String clientName = "";
		Calendar initialDate = Calendar.getInstance();

		Calendar finalDate; 
		double budget;
		boolean registerProjectComplete;
		int months = 0;

		System.out.println("Enter name");
		name=input.next();
		System.out.println("Enter clientName");
		clientName = input.next();

		System.out.println("Enter how many months the project will last");
		months= input.nextInt();

		finalDate = calculateFinalDate(initialDate, months);

		System.out.println(convDateFormat(finalDate));

		System.out.println("Enter budget");
		budget = input.nextDouble();

		registerProjectComplete =controller.registerProject(name, clientName, initialDate, finalDate, budget);
		if (registerProjectComplete){
			System.out.println("The project has been registered");
		}

		else{
			System.out.println("The project has not been registered");
		}
	}
	
/*
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fecha.getTime());
*/

/*      pedir fecha 
	System.out.println("Ingrese el ao:");
        int anio = scanner.nextInt();
        
        System.out.println("Ingrese el mes (1-12):");
        int mes = scanner.nextInt() - 1; // Restar 1 al mes porque los meses en la clase Calendar comienzan en 0
        
        System.out.println("Ingrese el dia del mes:");
        int dia = scanner.nextInt();
        
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, dia); */
		
	public String convDateFormat(Calendar date){

		String formatDate = simpleDateFormat.format(date.getTime()) ;
		return formatDate;

	}

	public Calendar calculateFinalDate(Calendar initialDate, int months){
		
		initialDate.add(Calendar.MONTH, months); 

		return initialDate;

	}

	//Incomplete
	public void searchProjectsAfterDate() {

	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {

	}
}
