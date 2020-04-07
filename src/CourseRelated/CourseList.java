package CourseRelated;
import java.util.ArrayList;

public class CourseList extends ArrayList<Course> {
	/**
	 * 
	 */
	public static CourseList MainCourseList=new CourseList();
	private static final long serialVersionUID = 1L;
	//构造函数
	public  CourseList() {
		super();
	}
	//查询课程的部分
	public Course getCourseById(String ID) {//根据课程的id来查找有没有这门课
		int len=this.size();
		int i=0;
		int temp;
		while(i<len&&(temp=this.get(i).getID().compareTo(ID))<=0) {
			if(temp==0)return this.get(i);
			i++;
		}
		return null;
	}
	public CourseList getCourseByKeyword(String Keyword) {//查找全部名字中含有Keyword的课程
		CourseList result=new CourseList();
		int len=this.size();
		int i;
		for(i=0;i<len;i++) {
			if(((Course)this.get(i)).getName().indexOf(Keyword)==-1) {//这门课不是目标课程
				
			}
			else {
				result.add(this.get(i));
			}
		}
		if(result.size()==0)return null;
		else return result;
	}
	//添加课程
	public boolean addCourse(Course member) {
		if(this.getCourseById(member.getID())==null) {//这门课程不再当前列表中
			this.add(member);
			this.sort(new Course());
			return true;
		}
		else {
			//System.out.println("课程已存在！");
			return false;
		}
	}
	//修改课程的部分，一律按照课程ID进行修改
	public void changeCourseID(String ID,String newID) {
		if(this.getCourseById(ID)==null) {
			System.out.println("没有这个课程！");
		}
		else {
			if(this.getCourseById(newID)!=null) {
				System.out.println("新ID已经被占用！");
			}
			else {
				Course a=this.getCourseById(ID);
				a.setID(newID);
			}
		}
	}
	public void changeCourseTeacher(String ID,String[] newTeachers) {//修改老师的名字
		if(this.getCourseById(ID)==null) {
			System.out.println("Course does not exist.");
		}
		else {
			Course a=this.getCourseById(ID);
			a.setTeachers(newTeachers);
			System.out.println("Update success.");
		}
	}
	public void changeCourseName(String ID,String newName) {//修改课程名字
		if(this.getCourseById(ID)==null) {
			System.out.println("Course does not exist.");
		}
		else {
			Course a=this.getCourseById(ID);
			a.setName(newName);
			System.out.println("Update success.");
		}
	}
	public void changeCourseCapacity(String ID, int newCapacity) {//修改课程容量，不是负数就行
		if(newCapacity<=0) {
			System.out.println("");
		}
		else {
			if(this.getCourseById(ID)==null) {
				System.out.println("Course does not exist.");
			}
			else {
				Course a=this.getCourseById(ID);
				a.setCapacity(newCapacity);
				System.out.println("Update success.");
			}
		}
	}
	
	//来自父类的方法
	@Override
	public String toString() {
		String result="";
		result+=String.format("Total: %d\n", this.size());
		int i,len=this.size();
		for(i=0;i<len;i++) {
			result+=String.format("%d. %s\n", i+1,this.get(i).toString());
		}
		result=result.substring(0, result.length()-1);
		return result;
	}
}
