package PeopleRelated;

import java.util.ArrayList;
import java.util.HashSet;

public class PersonList extends ArrayList<Person>{
	public static PersonList MainPersonList=new PersonList();
	private HashSet<String> TeacherIDs;//全部教师的ID
	private HashSet<String> StudentIDs;//全部学生的ID
	private HashSet<String> IDs;//全部人员的身份证号
	//构造方法
	public PersonList() {
		super();
		TeacherIDs=new HashSet<String>();
		StudentIDs=new HashSet<String>();
		IDs=new HashSet<String>();
	}
	
	//信息获取
	public Person getMember(String id) {
		Person p=null;
		if(IDs.contains(id)==false)return null;
		else {
			int i,len=this.size();
			for(i=0;i<len;i++) {
				if(this.get(i).getID().getID().compareTo(id)==0) {
					p=this.get(i);
					break;
				}
			}
			return p;
		}
	}
	
	//信息修改
	public boolean addPerson(String name,String id,String special_id,boolean mode) {//mode=true学生，否则是老师
		boolean result=true;
		IDNum new_id=new IDNum(id);
		Person p=new Person(name,new_id);
		if(p.checkIDLegal()==false) {
			System.out.println("ID illegal");
			return false;
		}
		if(IDs.contains(id)==true) {
			System.out.println("ID exists");
			return false;
		}
		if(p.checkNameLegal()==false) {
			System.out.println("Name illegal");
			return false;
		}
		if(mode==true) {//学生
			Student s=new Student(p,special_id);
			if(s.checkSidLegal()==false) {
				System.out.println("SID illegal");
				return false;
			}
			if(this.StudentIDs.contains(special_id)==true) {
				System.out.println("SID exists");
				return false;
			}
			this.add(s);
			this.IDs.add(id);
			this.StudentIDs.add(special_id);
			System.out.println("Add student success");
			return true;
		}
		else {
			Teacher t=new Teacher(p,special_id);
			if(t.checkTidLegal()==false) {
				System.out.println("TID illegal");
				return false;
			}
			if(this.TeacherIDs.contains(special_id)==true) {
				System.out.println("TID exists");
				return false;
			}
			this.add(t);
			this.IDs.add(id);
			this.TeacherIDs.add(special_id);
			System.out.println("Add teacher success");
			return true;
		}
	}
	public Person login(String id,String password) {
		Person p=null;
		int i,len=this.size();
		Person temp;
		for(i=0;i<len;i++) {
			temp=this.get(i);
			if(temp.getID().getID().compareTo(id)==0) {
				if(temp.getPassword().compareTo(password)==0) {
					p=temp;
					break;
				}
			}
		}
		return p;
	}
	public boolean changePassword(Person p,String new_password,String again) {
		if(Person.checkPassword(new_password)==false) {
			System.out.println("Password illegal");
			return false;
		}
		else if(again.compareTo(new_password)!=0) {
			System.out.println("The password you entered must be same with the former one");
			return false;
		}
		else {
			p.setPassword(new_password);
			System.out.println("Password changed successfully");
			return true;
		}
	}
}
