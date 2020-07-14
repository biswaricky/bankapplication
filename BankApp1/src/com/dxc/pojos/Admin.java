package com.dxc.pojos;

public class Admin 
{
   private String adminid;
   private String pwd;
   public Admin()
   {
	   
   }
public Admin(String adminid, String pwd) {
	super();
	this.adminid = adminid;
	this.pwd = pwd;
}
public String getAdminid() {
	return adminid;
}
public void setAdminid(String adminid) {
	this.adminid = adminid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public String toString() {
	return "Admin [adminid=" + adminid + ", pwd=" + pwd + "]";
}
   
   
}
