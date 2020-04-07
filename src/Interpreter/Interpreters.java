package Interpreter;

import java.util.Scanner;

public abstract class Interpreters {
	public abstract boolean checkFormat(String[] args);//用来检查参数是否正确
	public abstract void interprete(String args[],Scanner input);//用来执行指令
}
