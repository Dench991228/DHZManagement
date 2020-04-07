package PeopleRelated;

public class IDNum {
	
	private String num;
	
	//构造方法
	public IDNum() {
		super();
	}
	public IDNum(String x){
		if(IDNum.checkID(x))num=x;
		else num=null;
	}
	
	// 判断一个身份证号合不合法
	public static boolean checkID(String num) {
		//判断地区码是否合法
		int location;
		try {
			location=Integer.valueOf(num.substring(0, 6));
		}
		catch(NumberFormatException e) {
			return false;
		}
		
		//判断日期是否合法
		int[] numDays= {31,28,31,30,31,30,31,31,30,31,30,31};
		String yearS=num.substring(6, 10);
		String monthS=num.substring(10, 12);
		String dayS=num.substring(12, 14);
		int year,month,day;
		try {
			year=Integer.valueOf(yearS);
			month=Integer.valueOf(monthS);
			day=Integer.valueOf(dayS);
		}
		catch(NumberFormatException e) {
			return false;
		}
		//判断大小年
		if(year%100==0&&year>0) {
			if(year%400==0)numDays[1]+=1;
		}
		else if(year%4==0)numDays[1]+=1;
		//判断月份合法
		if(month>=13||month<1)return false;
		//判断日合法
		if(day>numDays[month-1]||day<-1)return false;
		
		//判断校验码是否合法
		int total=0;
		int i=num.length()-1;
		int len=i;
		while(i>=0) {
			if(num.charAt(i)=='X') {
				total+=(10*(Math.pow(2, len-i)%11));
			}
			else {
				total+=((num.charAt(i)-'0')*(Math.pow(2, len-i)%11));
			}
			i--;
		}
		//System.out.println("total="+total);
		if(total%11!=1)return false;
		return true;
	}
	
	//信息获取部分
	public int getYear() {//获取出生年份
		String yearS=num.substring(6, 10);
		int year;
		try {
			year=Integer.valueOf(yearS);
		}
		catch(NumberFormatException e) {
			return -1;
		}
		return year;
	}
	public int getMonth() {//获取出生月份
		String monthS=num.substring(10, 12);
		int month;
		try {
			month=Integer.valueOf(monthS);
		}
		catch(NumberFormatException e) {
			return -1;
		}
		return month;
	}
	public int getDay() {//获取出生日
		String dayS=num.substring(12, 14);
		int day;
		try {
			day=Integer.valueOf(dayS);
		}
		catch(NumberFormatException e) {
			return -1;
		}
		return day;
	}
	public int getGender() {//获取性别
		int gender=-1;
		int order;
		try {
			order=Integer.valueOf(num.substring(14, 17));
			gender=order%2;
		}
		catch(NumberFormatException e) {
			return -1;
		}
		return gender;
	}
	public String getID() {//获取当前的身份证号
		return num;
	}
	@Override
	public String toString() {
		return this.num;
	}
}
