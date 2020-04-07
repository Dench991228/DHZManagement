package Interpreter;

import java.util.Scanner;

import CourseRelated.*;
/*
 * gc指令格式 :
 * gc -id IDString
 * gc -key keywordString #n page (m records)
 * gc -all #npage (m records)
 */
public class gcInterpreter extends Interpreters{
	private boolean showCourses(CourseList cll,int n, int m) {//第n页开始，每页m行，返回true就继续程序，否则就退回
		int size_total=cll.size();
		if((n-1)*m<=size_total&&n<=0) {
			System.out.println("Course does not exist");
			return false;
		}
		else {
			int i=(n-1)*m+1;
			while(i<=size_total&&i<=n*m) {
				System.out.println(cll.get(i-1));
				i++;
			}
			return true;
		}
	}
	@Override
	public boolean checkFormat(String[] args) {
		// TODO Auto-generated method stub
		if(args.length<3)return false;
		else {
			if(args[1].compareTo("-key")==0) {
				if(args.length==5)return true;
				else return false;
			}
			else if(args[1].compareTo("-id")==0) {
				if(args.length==3)return true;
				else return false;
			}
			else if(args[1].compareTo("-all")==0) {
				if(args.length==4)return true;
				else return false;
			}
			else {
				System.out.println("illegal input");
				return false;
			}
		}
	}

	@Override
	public void interprete(String[] args, Scanner input) {
		// TODO Auto-generated method stub
		if(args[1].compareTo("-id")==0) {//按照id来找
			Course target=CourseList.MainCourseList.getCourseById(args[2]);
			System.out.println(target);
		}
		else if(args[1].compareTo("-key")==0) {//按照关键字查找课程
			int pos_page;//第几页
			int num_records;//每页几个记录
			try {
				pos_page=Integer.valueOf(args[3]);
				num_records=Integer.valueOf(args[4]);
			}
			catch(NumberFormatException e) {
				System.out.println("input illegal");
				return ;
			}
			CourseList cll=CourseList.MainCourseList.getCourseByKeyword(args[2]);
			boolean flag=this.showCourses(cll, pos_page, num_records);
			String command="s";
			while(flag) {
				System.out.println("n-next page, l-last page, q-quit");
				command=input.nextLine();
				if(command.compareTo("n")==0) {
					pos_page++;
					flag=this.showCourses(cll, pos_page, num_records);
				}
				else if(command.compareTo("l")==0) {
					pos_page--;
					flag=this.showCourses(cll, pos_page, num_records);
				}
				else {
					return;
				}
			}
		}
		else if(args[1].compareTo("-all")==0) {//全部课程
			int pos_page;//第几页
			int num_records;//每页几个记录
			try {
				pos_page=Integer.valueOf(args[2]);
				num_records=Integer.valueOf(args[3]);
			}
			catch(NumberFormatException e) {
				System.out.println("input illegal");
				return ;
			}
			CourseList cll=CourseList.MainCourseList;
			boolean flag=this.showCourses(cll, pos_page, num_records);
			String command="s";
			while(flag) {
				System.out.println("n-next page, l-last page, q-quit");
				command=input.next();
				if(command.compareTo("n")==0) {
					pos_page++;
					flag=this.showCourses(cll, pos_page, num_records);
				}
				else if(command.compareTo("l")==0) {
					pos_page--;
					flag=this.showCourses(cll, pos_page, num_records);
				}
				else {
					return;
				}
			}
		}
		else {
			System.out.println("input illegal");
		}
	}

}
