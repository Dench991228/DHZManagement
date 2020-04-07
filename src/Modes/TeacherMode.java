package Modes;
import Interpreter.*;

public class TeacherMode extends Mode{
	public TeacherMode() {
		this.Commands.put("chgpw", new chgpwInterpreter());
		this.Commands.put("myinfo", new myinfoInterpreter());
	}
}
