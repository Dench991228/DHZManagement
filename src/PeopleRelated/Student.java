package PeopleRelated;
import CourseRelated.*;

public class Student extends Person{
	protected String Sid;
	protected CourseList ChosenCourses;
	//static 类
	private boolean checkSid(String new_sid) {
		if(new_sid.matches("[0-9]{8}")) return true;
		else return false;
	}
	//构造函数
	public Student() {
		super();
		this.ChosenCourses=new CourseList();
	}
	public Student(String name,IDNum ID,String sid) {
		super(name,ID);
		if(this.checkSid(sid))this.Sid=sid;
		else this.Sid=null;
		this.ChosenCourses=new CourseList();
	}
	public Student(Person p,String sid) {
		super(p.getName(),p.getID());
		if(this.checkSid(sid))this.Sid=sid;
		else this.Sid=null;
		this.ChosenCourses=new CourseList();
	}
	
	//获取信息
	public CourseList getCourses() {
		return this.ChosenCourses;
	}
	public String getSid() {
		return this.Sid;
	}
	
	//合法性检查
	public boolean checkSidLegal() {
		return this.Sid!=null;
	}
	
	//展示信息
	@Override
	public String toString() {
		if(this.Name==null)return "Not initialized";
		else {
			String result=this.nameInfo()+this.idInfo()+this.genderInfo()+("Sid:"+this.Sid+"\n")+this.birthdayInfo();
			return result;
		}
	}
}
