package CourseRelated;
import java.util.Comparator;

public class Course implements Comparator<Course>{
	private String CourseID;
	private String CourseName;
	private String[] Teachers;
	private int Capacity;
	
	//构造方法
	public Course() {
		super();
	}
	public Course(String ID,String Name,String[] courseTeachers,int courseCapacity) {
		this.CourseID=ID;
		this.CourseName=Name;
		this.Teachers=courseTeachers;
		this.Capacity=courseCapacity;
	}
	
	//沟通方法
	public String getID() {
		return this.CourseID;
	}
	public String getName() {
		return this.CourseName;
	}
	public int getCapacity() {
		return this.Capacity;
	}
	public String[] getTeachers() {
		return this.Teachers;
	}
	
	//修改方法
	public void setTeachers(String[] newTeachers) {
		this.Teachers=newTeachers;
	}
	public void setCapacity(int newCapacity) {
		this.Capacity=newCapacity;
	}
	public void setID(String newCourseID) {
		this.CourseID=newCourseID;
	}
	public void setName(String newCourseName) {
		this.CourseName=newCourseName;
	}
	
	//合法性检查
	
	public static boolean checkLegalID(String ID) {
		boolean result=true;
		if(ID.length()!=10||ID.startsWith("BH")==false) {//开始不是BH或者长度不够
			result=false;
		}
		else if(ID.matches("^BH\\d{8}$")==false) {
			result=false;
		}
		return result;
	}
	public static boolean checkLegalTeachers(String[] Teachers) {//Teachers中的每一个字符串都trim过了
		boolean result=true;
		if(Teachers.length==0)result=false;
		else {
			int i,len=Teachers.length;
			for(i=0;i<len;i++) {
				if(Teachers[i].length()==0)result=false;
			}
		}
		return result;
	}
	public static boolean checkLegalName(String Name) {
		boolean result=true;
		if(Name.length()==0)result=false;
		return result;
	}
	public static boolean checkLegalCapacity(int cp) {
		boolean result=true;
		if(cp<0)result=false;
		return result;
	}
	
	
	
	//父类方法
	@Override
	public String toString() {
		String result="";
		int len=this.Teachers.length;
		String teacherList="[";
		int i;
		for(i=0;i<len-1;i++) {
			teacherList=teacherList.concat(this.Teachers[i]+",");
		}
		teacherList=teacherList.concat(this.Teachers[i]+"]");
		result=String.format("CID:%s, Name:%s, Teachers:%s, Capacity:%d", this.CourseID,this.CourseName,teacherList,this.Capacity);
		return result;
	}
	//Comparator接口方法
	@Override
	public int compare(Course o1, Course o2) {//完全按照ID的字典序排列即可
		// TODO Auto-generated method stub
		return o1.getID().compareTo(o2.getID());
	}
}
