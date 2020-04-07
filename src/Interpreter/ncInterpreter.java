package Interpreter;

import java.util.Scanner;

import CourseRelated.Course;
import CourseRelated.CourseList;
/*
 * nc指令：添加新课程
 * 输入格式：nc ID name teachers capacity
 * 如果ID存在，就输出"Course exists",如果不存在就输出"Add success"
 * 数据非法输出"Course add illegal"，包括课程名中出现英文字母和数字之外的字符，老师名称有英文字母之外的字符，容量为负
 */
public class ncInterpreter extends Interpreters{

	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==5) {
			return true;
		}
		else {
			System.out.println("inpt illegal");
			return false;
		}
	}
	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		CourseList cur=CourseList.MainCourseList;
		if(cur.getCourseById(args[1])!=null)System.out.println("Course exists");//检查ID存在情况
		else {
			boolean teacherLegal=true;
			boolean nameLegal=true;
			boolean capacityLegal=true;
			int capacity;
			String[] teachers=(args[3].substring(1, args[3].length()-1)).split(",");
			try {//获得课程容量
				capacity=Integer.valueOf(args[4]);
			}
			catch(NumberFormatException e) {
				System.out.println("illegal input");
				capacity=-1;
			}
			if(args[2].matches("[a-zA-Z0-9]+")==false)nameLegal=false;//判断名字
			if(capacity<0)capacityLegal=false;//判断容量
			int i,len=teachers.length;
			for(i=0;i<len;i++) {//判断老师
				teachers[i]=teachers[i].trim();
				//System.out.println(teachers[i]);
				if(teachers[i].matches("[a-zA-Z]+")==false) {
					teacherLegal=false;
					break;
				}
			}
			if(teacherLegal&&nameLegal&&capacityLegal) {
				Course newCourse=new Course(args[1],args[2],teachers,capacity);
				boolean flag;
				cur.addCourse(newCourse);
				System.out.println("Add success");
			}
			else {
				//System.out.println(capacityLegal+" "+teacherLegal+" "+nameLegal);
				System.out.println("Course add illegal");
			}
		}
	}
}
