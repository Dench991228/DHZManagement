package Modes;

import java.util.Scanner;
import java.util.TreeMap;

import Interpreter.*;

public class SudoMode extends Mode{
	public SudoMode() {
		this.Commands=new TreeMap<String,Interpreters>();
		this.Commands.put("np", new npInterpreter());
	}
}
