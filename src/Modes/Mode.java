package Modes;

import java.util.Scanner;
import java.util.TreeMap;
import Interpreter.*;
import PeopleRelated.Person;

public class Mode {
	public static boolean SystemFlag=true;//表示整个系统是否还在运行
	public static Person CurrentOperator;
	public static int LoginStatus;
	protected TreeMap<String,Interpreters> Commands;
	public Mode() {
		this.Commands=new TreeMap<String,Interpreters>();
	}
	public void Enter(Scanner input){
		boolean flag=true;
		while(input.hasNext()&&flag) {
			String input_line=input.nextLine();
			String[] arguments;
			if(input_line.compareTo("QUIT")==0) {
				Mode.SystemFlag=false;
				flag=false;
				
				//System.out.println("Recieved");
				break;
			}
			else if(input_line.compareTo("back")==0) {
				System.out.println("backed");
				flag=false;
				break;
			}
			else {
				arguments=input_line.split(" ");
				Interpreters x=Commands.get(arguments[0]);
				if(x==null)System.out.println("illegal input");
				else if(x.checkFormat(arguments)==false)continue;
				else x.interprete(arguments, input);
			}
		}
	}
}
