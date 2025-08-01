package com.model;
//POJO class /Model class /Entity class==> it is raw data holder class...
public class Student {
private int sid;
private String sname;
private int age;

public int getSid() {
	return sid;
}
public String getSname() {
	return sname;
}
public int getAge() {
	return age;
}
public void setSid(int sid) {
	this.sid = sid;
}
public void setSname(String sname) {
	this.sname = sname;
}
public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + "]";
}




}
