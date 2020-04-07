package Interpreter;

import java.util.Scanner;

import PeopleRelated.IDNum;

/*
 *指令格式： cid String 检查后面的String是不是身份证号
 *输出格式：如果是，输出true，否则输出false，其他情况输出"input illegal"
 */
public class cidInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==2) {
			return true;
		}
		else {
			System.out.println("input illegal");
			return false;
		}
	}

	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		if(IDNum.checkID(args[1])==true)System.out.println("true");
		else System.out.println("false");
	}

}
