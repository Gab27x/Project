package model;

import java.text.ParseException;
import java.util.Calendar;


public class Controller {
	public static final int SIZE = 10;
	private Project[] projects;
	public Controller() {

		projects = new Project[SIZE];
	
	}
	
	// case 1

	public boolean registerProject( String name, String clientName,String projectType, Calendar initialDate, Calendar finalDate, double budget) {
		boolean registerProjectComplete = false;
		int pos = posAvailable();
		if(pos != -1){
			projects[pos] = new Project(name, clientName,projectType, initialDate, finalDate, budget) ;
			
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

	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate(Calendar date) throws ParseException {
		String msg = "";
		for(int i=0 ;i<SIZE ;i++){
			if(projects[i]!=null&&projects[i].getFinalDate().compareTo(date)<0){
				msg += projects[i].getProjectInfo(); 

			}


		}


		return msg;

	}


	//case 3

	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(Calendar date) throws ParseException{

		String msg = "";
		for(int i=0 ;i<SIZE  ;i++){
			if( projects[i]!=null && projects[i].getInitialDate().compareTo(date)>0 ) {
				msg += projects[i].getProjectInfo(); 
			
			}


		}
		return msg;

	}
}
