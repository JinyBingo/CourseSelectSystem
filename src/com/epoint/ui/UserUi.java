package com.epoint.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.epoint.man.Admin;
import com.epoint.man.Student;
import com.epoint.man.User;

public class UserUi {
	
	 public UserUi() throws FileNotFoundException, ClassNotFoundException, IOException
	 {
		 
		 int loginError=0;
		while(true)
		{
			 System.out.println("请输入用户名:");
			 Scanner in=new Scanner(System.in);
			 String loginid=in.nextLine();
			 while(loginid.length()<5)
			 {
				 
					 System.out.println("登录ID输入错误，必须大于5位,重新输入ID");
					 loginid=in.nextLine();
			 }
			 System.out.println("请输入密码:");
			 String password=in.nextLine();
			 User user=new User(loginid,password);
			 
			 if(user.login())
			 {
				 loginError=0;
				 System.out.println("登录成功！");
				 if(user.checkUsertype()==1||user.checkUsertype()==2)
					 AdminManagebar(user);
				 else
					 studentMunuBar(user);
					 
			 }
			 else
				 System.out.println("输入用户名或密码不正确，登录失败");
			   loginError++;
			   if(loginError>2)
			   {
				   System.out.println("连续登录失败3次，系统将自动！\n  再见！");
				   System.exit(0);
			   }
		 }
	 }
			 
		 
	 

	public static void studentMunuBar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		      System.out.println(u.loginId+"同学，你好！请输入服务选项\n1-选择课程\n2-查询可选\n3-查看已选\n4-修改选课\n5-修改密码\n6-注销登录");
		      Scanner in=new Scanner(System.in);
		      String choose=in.nextLine();
		      switch(choose)
		      {
		      case "1":Student.selectCourse(u);break;
		      case "2":Student.seeCanSelectCourse(u);break;
		      case "3":Student.seeSelectedCourse(u);break;
		      case "4":Student.changeCourse(u);break;
		      case "5":Student.changePassword(u);break;
		      case "6":new UserUi();break;
		      default:
		    	  System.out.println("无效输入，请重新选择！");
		    	  studentMunuBar(u);
		      }
	}

	

	public static void AdminManagebar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		if(u.checkUsertype()==1)
		{
			System.out.println(u.loginId+"系统管理员，你好!请输入服务类型：\n1-课程管理\n2-学生管理\n3-普通管理员管理\n4-注销登录");
		
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":AdminCourseManagebar(u);break;
		case "2":adminStudentManagebar(u);break;
		case "3":teaAndAdminManagebar(u);break;
		case "4":System.out.println("注销登录成功！再见！");
				new UserUi();break;
				default:
					System.out.println("输入有误，请重新选择！");
					AdminManagebar(u);
		}
		}
		else if(u.checkUsertype()==2)
		{
			System.out.println(u.loginId+"管理员，你好！请输入你的服务类型：\n1-课程管理\n2-学生管理：\n3-注销登录");
			Scanner in=new Scanner(System.in);
			String choose=in.nextLine();
			switch(choose)
			{
			case "1":AdminCourseManagebar(u);break;
			case "2":adminStudentManagebar(u);break;
			case "3":System.out.println("注销登陆成功！再见！");
			new UserUi();break;
			default:
				System.out.println("输入有误，请重新选择！");
				AdminManagebar(u);
			}
		}
		else if(u.checkUsertype()==3)
		{
			System.out.println(u.loginId+"老师，你好！请输入你服务类型：\n1-教学管理\n2-学生管理\n3-注销登录");
		  	Scanner in=new Scanner(System.in);
		  	String choose=in.nextLine();
		  	switch(choose)
		  	{
		  	case "1":teacherCourseManage(u);break;
		  	case "2":teacheStudentmanage(u);break;
		  	case "3":
		  		System.out.println("注销登录成功！再见！");
		  		new UserUi();
		  		default:
		  			System.out.println("输入有误，请重新选择！");
		  			AdminManagebar(u);
		  	}
		}
		
	}

	public static void teaAndAdminManagebar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("请输入服务类型：\n1-新增普通管理员\n2-查看普通管理员\n3-删除普通管理员\n4-修改普通管理员\n5-返回上级菜单\6-注销登录");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":new Admin().addAdmin(u);addStudentbar(u);break;
		case "2":Admin.seeAdmin(u);break;
		case "3":new Admin().deleteAdmin(u);break;
		case "4":new Admin().changeAdmin(u);break;
		case "5":AdminManagebar(u);break;
		case "6":System.out.println("注销登录成功！再见！");
		new UserUi();break;
		default:
			System.out.println("输入有误，请重新选择！");
			teaAndAdminManagebar(u);
			
		}
	}

	public static void adminStudentManagebar(User u) {
		System.out.println("请输入服务类型：\n1-新增学生\n2-查看学生\n3-删除学生\n4-修改学生\n5-返回上级菜单\6-注销登录");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":addStudentbar(u);
				
			break;
		case "2":try {
				new Admin().seeStudent(u);
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
		case "3":Admin.deleteStudent(u);break;
		case "4":Admin.changeCourse(u);break;
		case "5":try {
				AdminManagebar(u);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
		case "6":System.out.println("注销登录成功！再见！");
			try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
		default:
			System.out.println("输入有误，请重新选择！");
			
				adminStudentManagebar(u);
			
			
		}
		
	}
public static void addStudentbar(User u)
{
	Scanner in=new Scanner(System.in);
	try {
		if(new Admin().addStudent())
			System.out.println("添加学生完成！是否继续？\ny-继续\nf-返回上级菜单\nx-注销登录");
	} catch (ClassNotFoundException | IOException e) {
		
		e.printStackTrace();
	}
	   String choose2=in.nextLine();
	   switch(choose2)
	   {
	   case "y":try {
			new Admin().addStudent();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}addStudentbar(u);break;
	   case "n":adminStudentManagebar(u);break;
	   case "x":try {
			new UserUi();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}break;
	   default:
		   System.out.println("输入有误，自动返回上级菜单！");
		   adminStudentManagebar(u);
	   }
}

	public static void manageAdminbar(User u) {
		// TODO Auto-generated method stub
		
	}

	

	public static void teacheStudentmanage(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("请输入你服务类型：\n1-查看选择你课的学生\2-查看你所有授的课程\n3-返回上级菜单\n4-注销登录");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":teacherSeeStudent(u);break;
		case "2":teacherSeeCourse(u);break;
		case "3":AdminManagebar(u);break;
		case "4":
			System.out.println("注销登录成功，再见！");
			new UserUi();
		default:
			System.out.println("输入有误，请重新选择！");
			teacheStudentmanage(u);
		}
		
	}

	public static void teacherSeeCourse(User u) {
		// TODO Auto-generated method stub
		
	}

	public static void teacherSeeStudent(User u) {
		System.out.println("请选择查看类型：\1n-查看所以学生\n2-查看指定学生");
		
		
	}

	public static void teacherCourseManage(User u) {
		System.out.println("请选择查看类型:\n1-查看你的所以授课\n2-返回上级菜单\n3-返回主菜单\n4-注销登录");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":;break;
		case "2":try {
				teacheStudentmanage(u);
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
		case "3":try {
				AdminManagebar(u);
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
		case "4":
			System.out.println("注销登录成功！再见！");
			try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
			default:
				System.out.println("输入有误，请重新选择！");
				teacherCourseManage(u);
		}
		
	}

	
	public  static void AdminCourseManagebar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("请输入服务类型：\n1-课程新增\n2-课程查看\n3-课程删除\n4-课程修改\n5-返回上级菜单\n6-注销登录");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":addCoursebar(u);
		           break;
		
		case "2":Admin.seeCourse(u);break;
		case "3":Admin.deleteStudent(u);break;
		case "4":Admin.changeCourse(u);break;
		case "5":AdminManagebar(u);break;
		case "6":System.out.println("注销登录成功！再见！");
		new UserUi();break;
		default:
			System.out.println("输入有误，请重新选择！");
			AdminCourseManagebar(u);
			
		}
		
		
	}
 public static void addCoursebar(User u)
 {
	 Scanner in=new Scanner(System.in);
	 if(Admin.addCourse(u))
	      System.out.println("添加课程成功！是否继续？ y-继续  n-返回上级菜单 x-注销登录");
               String choose=in.nextLine();
               switch(choose)
               {
               case "y":Admin.addCourse(u);addCoursebar(u);break;
               case "n":try {
					AdminCourseManagebar(u);
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}break;
               case "x":System.out.println("注销登录成功！再见！");
				try {
					new UserUi();
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
               break;
               default:
               	System.out.println("输入有误，自动返回上级菜单！");
               	try {
					AdminCourseManagebar(u);
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
               }
 }
	

	
	
}
