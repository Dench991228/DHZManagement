package Interpreter;

import java.util.Scanner;
import PeopleRelated.*;
import Modes.*;

public class myinfoInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=1) {
			System.out.println("illegal input");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		if(Mode.CurrentOperator instanceof Teacher) {
			Teacher t=(Teacher)Mode.CurrentOperator;
			System.out.print(t);
		}
		else{
			Student s=(Student)Mode.CurrentOperator;
			System.out.print(s);
		}
	}

}
