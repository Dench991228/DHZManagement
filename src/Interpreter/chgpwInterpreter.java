package Interpreter;

import java.util.Scanner;
import PeopleRelated.*;
import Modes.*;

public class chgpwInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=3) {
			System.out.println("input illegal");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		PersonList.MainPersonList.changePassword(Mode.CurrentOperator, args[1],args[2]);
	}

}
