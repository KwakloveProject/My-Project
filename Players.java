package 나혼자실헝할프로그램.copy12;

import java.io.Serializable;

public class Players implements Serializable
{
	private String name; 
	private String phonenum;
	public Players(String name, String phonenum) {
		super();
		this.name = name;
		this.phonenum = phonenum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	@Override
	public String toString() {
		return "name=" + name + ", phonenum=" + phonenum ;
	} 
	
}
