package Interpreter;

import java.util.Scanner;

import PeopleRelated.IDNum;
import PeopleRelated.*;

/*
 * np指令输入格式：np name IDNum
 * np指令输出：如果身份证号没问题，那就输出这个人的信息，如果有问题，那就输出"ID illegal"，其他情况输出"input illegal"
 */
public class npInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==3) {
			return true;
		}
		else{
			System.out.println("input illegal");
			return false;
		}
	}
	
	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		Person p=Person.newPerson(args[1], args[2]);
		if(p==null) {
			System.out.println("ID illegal");
		}
		else {
			System.out.println(p);
		}
	}
	
}
