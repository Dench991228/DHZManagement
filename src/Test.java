import java.util.Scanner;
import java.util.TreeMap;

import CourseRelated.*;
import Interpreter.*;
import PeopleRelated.*;
import Modes.*;

public class Test {
	public static CourseList MainList=new CourseList();
	public static PersonList MainPersonList=new PersonList();
	public static Person CurrentOperator;
	public static int LoginStatus;
	public static boolean systemFlag=true;
	public static void main(String[] args) {
		Scanner inputline=new Scanner(System.in);
		String[] input;
		IIIMode mode=new IIIMode();
		mode.Enter(inputline);
	}
}
