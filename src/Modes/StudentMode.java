package Modes;

import java.util.Scanner;
import java.util.TreeMap;

import Interpreter.*;

public class StudentMode extends Mode{
	public StudentMode() {
		this.Commands.put("chgpw", new chgpwInterpreter());
		this.Commands.put("myinfo", new myinfoInterpreter());
	}
}
