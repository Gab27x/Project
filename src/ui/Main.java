package ui;
import java.util.Calendar;
import java.util.Scanner;
import model.Controller;
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

	public Main() {

		input = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main view = new Main();
		int option = 0;
		do{
			view.menu();
		}while(option!=0);
		view.executeOption(option);
		view.input.close();
	}

	// Incomplete
	public void menu() {
		System.out.println("0.Exit");
		System.out.println("1.");
		System.out.println("2.");
		System.out.println("3.");
		//System.out.println("4.");

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
		finalDate =calculateFinalDate(initialDate, months);

		

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
