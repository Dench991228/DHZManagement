package Modes;

import Interpreter.*;

public class IIIMode extends Mode{
	public IIIMode() {
		this.Commands.put("cid", new cidInterpreter());
		this.Commands.put("gc", new gcInterpreter());
		this.Commands.put("nc", new ncInterpreter());
		this.Commands.put("udc", new udcInterpreter());
		this.Commands.put("np", new npInterpreter());
	}
}
