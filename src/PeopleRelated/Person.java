package PeopleRelated;
import java.util.Calendar;
import java.util.Date;

public class Person {
	public static Person CurrentOperator;
	protected IDNum ID;
	protected String Name;
	protected Calendar Birthday;
	protected int Gender;//1 男，0 女，-1有问题
	protected String Password;
	//static类
	public static boolean checkPassword(String new_password) {
		boolean result=false;
		int has_number=0;
		int has_upper=0;
		int has_lower=0;
		int has_other=0;
		int i,len=new_password.length();
		if(!(len>=6&&len<=18))return false;
		for(i=0;i<len;i++) {
			char temp=new_password.charAt(i);
			if(temp>='0'&&temp<='9')has_number=1;
			if(temp>='a'&&temp<='z')has_lower=1;
			if(temp>='A'&&temp<='Z')has_upper=1;
			if(String.valueOf(temp).matches("[^0-9a-zA-Z]"))has_other=1;
		}
		if(has_number+has_lower+has_upper+has_other>=2)result=true;
		return result;
	}
	//构造函数
	public Person() {
		super();
	}
	public Person(String new_name,IDNum new_id) {
		if(new_id.getID()==null) {
			this.ID=null;
		}
		else {
			this.Name=new_name;
			this.ID=new_id;
			this.Gender=new_id.getGender();
			this.Birthday=Calendar.getInstance();
			this.Birthday.set(new_id.getYear(), new_id.getMonth(), new_id.getDay());
			this.Password=null;
			this.Password="a12345";
		}
	}
	public static Person newPerson(String name,String id) {
		Person p=new Person();
		IDNum ID=new IDNum(id);
		if(ID.getID()==null)p.Name=null;
		else {
			p.Name=name;
			p.ID=ID;
			p.Birthday=Calendar.getInstance();
			p.Birthday.set(ID.getYear(), ID.getMonth(), ID.getDay());
			p.Gender=ID.getGender();
			p.Password="a12345";
		}
		return p;
	}
	//合法性检查
	public boolean checkIDLegal() {
		if(this.ID==null)return false;
		else return true;
	}
	public boolean checkNameLegal() {
		if(this.Name.matches("[a-zA-Z]+"))return true;
		else return false;
	}
	public boolean checkPasswordLegal() {
		if(this.Password==null)return false;
		else return true;
	}
	
	//获得信息
	public IDNum getID() {
		return this.ID;
	}
	public String getName() {
		return this.Name;
	}
	public Calendar getBirth() {
		return this.Birthday;
	}
	public int getGender() {
		return this.Gender;
	}
	public String getPassword() {
		return this.Password;
	}
	
	//修改信息
	public boolean setPassword(String new_password) {//true：修改成功，false：修改失败
		if(Person.checkPassword(new_password)) {
			this.Password=new_password;
			return true;
		}
		return false;
	}
	
	//展示信息相关函数
	protected String nameInfo() {
		return String.format("Name:%s\n", this.Name);
	}
	protected String idInfo() {
		return String.format("IDNum:%s\n", this.ID.getID());
	}
	protected String genderInfo() {
		return String.format("Gender:%c\n",this.Gender==1?'M':'F');
	}
	protected String birthdayInfo() {
		return ("Birthday:"+ID.getID().substring(6,10)+"/"+ID.getID().substring(10,12)+"/"+ID.getID().substring(12, 14)+"\n");
	}
	
	//覆盖函数
	@Override
	public String toString() {
		if(Name==null)return "Not initialized";
		else {
			String result=this.nameInfo()+this.idInfo()+this.genderInfo()+this.birthdayInfo();
			return result;
		}
	}
}
