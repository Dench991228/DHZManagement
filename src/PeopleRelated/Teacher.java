package PeopleRelated;
import CourseRelated.*;

public class Teacher extends Person{
	protected String Tid;
	protected CourseList TaughtCourses;
	
	//static函数
	private boolean checkTid(String tid) {
		return tid.matches("[0-9]{5}");
	}
	
	//合法性判断
	public boolean checkTidLegal() {
		return this.Tid!=null;
	}
	
	//构造函数
	public Teacher() {
		super();
		this.TaughtCourses=new CourseList();
	}
	public Teacher(String new_name,IDNum id,String new_tid) {
		super(new_name,id);
		if(this.checkTid(new_tid))this.Tid=new_tid;
		else this.Tid=null;
		this.TaughtCourses=new CourseList();
	}
	public Teacher(Person p,String tid) {
		super(p.getName(),p.getID());
		if(this.checkTid(tid))this.Tid=tid;
		else this.Tid=null;
		this.TaughtCourses=new CourseList();
	}
	//获取信息
	public CourseList getCourses() {
		return this.TaughtCourses;
	}
	public String getTid() {
		return this.Tid;
	}
	//展示信息
	@Override
	public String toString() {
		if(this.Name==null)return "Not initialized";
		else {
			String result=this.nameInfo()+this.idInfo()+this.genderInfo()+("Tid:"+this.Tid+"\n")+this.birthdayInfo();
			return result;
		}
	}
}
