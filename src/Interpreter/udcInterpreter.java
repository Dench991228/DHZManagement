package Interpreter;

import java.util.Scanner;
import CourseRelated.*;
/*
 * udc指令：更新课程信息
 * 输入格式：
 * udc ID -n newNameString:修改名字
 * udc ID -t teachersString:修改教师
 * udc ID -c capacityString:修改容量
 */
public class udcInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==4) {
			return true;
		}
		else {
			System.out.println("illegal input");
			return false;
		}
		
	}

	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		CourseList cll=CourseList.MainCourseList;
		if(args[2].compareTo("-n")==0) {//修改名字
			if(args[3].matches("[a-zA-Z0-9]")==false)System.out.println("Update fail");
			else cll.changeCourseName(args[1], args[3]);
		}
		else if(args[2].compareTo("-t")==0) {//修改老师
			boolean flag=true;
			String[] teachers=(args[3].substring(1, args[3].length()-1)).split(",");
			int i,len=teachers.length;
			for(i=0;i<len;i++) {
				teachers[i]=teachers[i].trim();
				if(teachers[i].matches("[a-zA-Z]")==false)flag=false;
			}
			if(flag)cll.changeCourseTeacher(args[1], teachers);
			else System.out.println("Update fail");
		}
		else if(args[2].compareTo("-c")==0) {//修改容量
			int capacity;
			try {
				capacity=Integer.valueOf(args[3]);
			}
			catch(NumberFormatException e) {
				capacity=-1;
			}
			if(capacity<0)System.out.println("Update fail");
			else cll.changeCourseCapacity(args[1], capacity);
		}
		else {//错误
			System.out.println("input illegal");
		}
	}

}
