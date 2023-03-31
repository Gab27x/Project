package model;

import java.util.Calendar;


public class Controller {
	public static final int SIZE = 10;
	private Project[] projects;
	private Calendar calendar;

	public Controller() {

		projects = new Project[SIZE];
	
	}
	
	// case 1
	//Incomplete
	public boolean registerProject( String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {
		boolean registerProjectComplete = false;
		int pos = posAvailable();
		if(pos != -1){
			projects[pos] = new Project(name, clientName, initialDate, finalDate, budget) ;
			
			registerProjectComplete = true;
		}

		return registerProjectComplete;
	}


	public int posAvailable(){
		int pos = -1;
		boolean posFounded = false;

		for (int i=0;i <SIZE && !posFounded; i++){
			if (projects[i] == null){

				pos = i;
				posFounded = true;
			}

		}


		
		return pos;
	}


	// case 2
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate(Calendar date) {
		String msg = "";
		for(int i=0 ;i<SIZE ;i++){
			if(projects[i].getInitialDate().compareTo(date)<0){


			}


		}


		return msg;

	}


	//case 3
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(Calendar date) {

		String msg = "";
		for(int i=0 ;i<SIZE ;i++){
			if(projects[i].getFinalDate().compareTo(date)>0){


			}


		}
		return msg;

	}
}
