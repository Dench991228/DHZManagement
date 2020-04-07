package Interpreter;

import java.util.Scanner;
import PeopleRelated.*;
import PeopleRelated.*;
import Modes.*;

public class loginInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==4) {
			return true;
		}
		else {
			System.out.println("illegal input");
			return false;
		}
	}

	@Override
	public void interprete(String[] args, Scanner input){
		// TODO Auto-generated method stub
		Person p=PersonList.MainPersonList.login(args[2], args[3]);
		if(args[1].compareTo("-t")==0) {
			if(p!=null&&p instanceof Teacher) {
				System.out.println("Login success");
				Mode.CurrentOperator=p;
				Mode.LoginStatus=1;
			}
			else {
				System.out.println("Login Error. Your ID or password maybe wrong.");
				Mode.LoginStatus=-1;
			}
		}
		else if(args[1].compareTo("-s")==0) {
			if(p!=null&&p instanceof Student) {
				System.out.println("Login success");
				Mode.CurrentOperator=p;
				Mode.LoginStatus=0;
			}
			else {
				System.out.println("Login Error. Your ID or password maybe wrong.");
				Mode.LoginStatus=-1;
			}
		}
		else {
			System.out.println("illegal input");
			Mode.LoginStatus=-1;
		}
	}
}
