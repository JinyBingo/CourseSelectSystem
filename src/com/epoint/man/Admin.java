package com.epoint.man;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.epoint.logic.Course;
import com.epoint.ui.UserUi;

public class Admin extends User implements Serializable{
	public static final long serialVersionUID = 1L;
	
	public Admin(User u)
	{
		
		this.usertype="普通管理员";
	}
	public Admin(String loginid,String name,String sex,String age,String department)
	{
		//super();
		this.loginId=loginid;
		this.password=loginid;//初始密码为工号
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.department=department;
		if(loginid.substring(0,5).equals("admin"))
		this.usertype="普通管理员";
		else if(loginid.substring(0, 5).equals("teach"))
			this.usertype="教师";
		
	}
	

	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public static boolean addStudent() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		
		System.out.print("请输入增加学生学号(以数字开始)：\n");
		Scanner in=new Scanner(System.in);
		String sno=in.nextLine();
	  System.out.print("请输入学生姓名：\n");
		String name=in.nextLine();
		 System.out.println("请输入学生性别：");
		  String sex="";
		//while(!(sex.equals("男")||sex.equals("女")))
				//{
			System.out.println("性别只能是男或者女！");
	sex=in.nextLine();
				//}
		System.out.println("请输入学生年龄：");
		 String age=in.nextLine();
		 System.out.println("请输入 学生专业 ：");
		   String major=in.nextLine();
		
		  return new User().WriteUser(new Student(sno,name,sex,age,major));
	}
	//public static boolean studentQuery()
	//{
		//HashMap<String,User> map=;
	public static void seeStudent(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("请输入查看选项: \n 1-查看所有学生 \n 2-查询指定学生");
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
	if(u.checkUsertype()==1)
	{
		switch(choose)
		{
		
		      case "1":
		
			     System.out.println("学号              "+"姓名           "+"性别        "+"年龄             "+"专业            "+"账户密码");
		       for(Map.Entry<String, User>entry:map.entrySet())
		         {
			  
			         if(entry.getValue().usertype.equals("学生"))
			          System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     "+entry.getValue().password);
		         }
		       System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
		            String choose2=in.nextLine();
		               switch(choose2)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("无效输入,自动返回上级菜单!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
		           break;
		       case "2":
			           System.out.println("请输入查询的学生的学号:");
			          String sno=in.nextLine();
			        for(Map.Entry<String, User>entry:map.entrySet())
			         {
				        if(entry.getKey().equals(sno))
				         {
				        	System.out.println("学号              "+"姓名           "+"性别        "+"年龄             "+"专业            "+"账户密码        ");
					        System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     "+entry.getValue().password);
				         }
			          }
			        System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
		            String choose3=in.nextLine();
		               switch(choose3)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("无效输入,自动返回上级菜单!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
			        break;
		       default:
		       
              	 System.out.println("无效输入,自动返回上级菜单!");
              
              	 Admin.seeStudent(u);
		    	   
		 }
	}
	else if(u.checkUsertype()==2)//管理员没有 看学生账户密码的权限
	{
		switch(choose)
		{
		
		      case "1":
		
			     System.out.println("学号              "+"姓名           "+"性别        "+"年龄             "+"专业            ");
		       for(Map.Entry<String, User>entry:map.entrySet())
		         {
			  
			         if(entry.getValue().usertype.equals("学生"))
			          System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     ");
		         }
		       System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
		            String choose2=in.nextLine();
		               switch(choose2)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("无效输入,自动返回上级菜单!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
		           break;
		       case "2":
			           System.out.println("请输入查询的学生的学号:");
			          String sno=in.nextLine();
			        for(Map.Entry<String, User>entry:map.entrySet())
			         {
				        if(entry.getKey().equals(sno))
				         {
				        	System.out.println("学号              "+"姓名           "+"性别        "+"年龄             "+"专业            ");
					        System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     ");
				         }
			          }
			        System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
		            String choose3=in.nextLine();
		               switch(choose3)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("无效输入,自动返回上级菜单!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
			        break;
		       default:
		       
              	 System.out.println("无效输入,自动返回上级菜单!");
              
              	 Admin.seeStudent(u);
		    	   
		 }
	}
		
		
	}
	public static void  deleteStudent(User u) {
		boolean b=false;
		System.out.println("请输入需要删除指定学生的学号:");
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		String loginid=in.nextLine();
		
		for(Iterator<Map.Entry<String, User>>it=map.entrySet().iterator();it.hasNext();)
		{
			Map.Entry<String,User> item=it.next();
			
			if(item.getKey().equals(loginid))
			{
				b=true;
				it.remove();
				System.out.println("学生"+loginid+"删除成功");
				User.WriteUserToFile(map);
				
				System.out.println("是否继续？y-是  n-返回上级菜单 x-注销登陆");
				
				String choose=in.nextLine();
				switch(choose)
				{
				case "y":deleteStudent(u);break;
				case "n":UserUi.adminStudentManagebar(u);break;
				case "x":System.out.println("注销登录成功！再见！");
					try {
						new UserUi();
					} catch (ClassNotFoundException | IOException e) {
						
						e.printStackTrace();
					}
					break;
					default:
						System.out.println("输入有误，自动返回上级菜单！");
						UserUi.adminStudentManagebar(u);
				}
			}
			
			
		}
		
		
		if(b==false)
		{
			System.out.println("学生不存在无法删除!输入y-继续删除  其他键-返回到上级菜单！");
			String choose2=in.nextLine();
			
			if(choose2.equals("y"))
			deleteStudent(u);
			else
				UserUi.adminStudentManagebar(u);
				
		}	
		
			
		
		
	}
	public static void changeStudent(User u) {
		
		System.out.println("请输入需要修改指定学生的学号:");//这里不考虑修改学生是否存在
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		String loginid=in.nextLine();
		System.out.print("请输入学生姓名：\n");
		String name=in.nextLine();
		System.out.println("请输入学生性别：");
		String sex=in.nextLine();
		System.out.println("请输入学生年龄：");
		String age=in.nextLine();
		System.out.println("请输入 学生专业 ：");
		String major=in.nextLine();
		map.put(loginid,new Student(loginid,name,sex,age,major));
		WriteUserToFile(map);
		System.out.println("修改成功，是否继续 y-继续 n-返回上级才菜单 x-注销登录");
		String choose=in.nextLine();
		switch(choose)
		{
		case "y":changeStudent(u);break;
		case "n":UserUi.adminStudentManagebar(u);break;
		case "x":System.out.println("注销登录成功！再见！");
			try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
			default:
			System.out.println("输入有误，自动返回上级菜单！");
			UserUi.adminStudentManagebar(u);
		}
	}
	public void changeStudentPassword(User u) {
		
		System.out.println("请输入需要修改密码指定学生的学号:");
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		System.out.println("请输入修改后密码:");
		String password=in.nextLine();
		String loginid=in.nextLine();
		for(Map.Entry<String, User>entry:map.entrySet())
		{
			if(entry.getKey().equals(loginid))
			{
				map.put(loginid,new Student(loginid,entry.getValue().name,entry.getValue().sex,entry.getValue().age,entry.getValue().major,password));
				WriteUserToFile(map); 
			    System.out.println(loginid+"学生密码修改成功");
			}
		}
		
		
	}
	
	public static boolean addCourse(User u)  {
		System.out.print("请输入增加课程号：\n");//这里不再考虑课程是否存在
		Scanner in=new Scanner(System.in);
		String courseid=in.nextLine();
		System.out.print("请输入课程名：\n");
		String coursename=in.nextLine();
		System.out.println("请输入课程任课老师工号：");
		String courseteacher=in.nextLine();
		System.out.println("请输入课程类型：");
		String coursetype=in.nextLine();
		
		return Course.WriteCourse(new Course(courseid,coursename,courseteacher,coursetype)); 
		
	}
	public static void seeCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException 
	{
		System.out.println("请输入查看选项: \n 1-查看所有课程 \n 2-查询指定课程");//如果查询显示列表为空则表示课程不存在
		HashMap<String,Course> map=Course.ReadCourseFromFile();
		if(map.size()==0)
			System.out.println("课程列表为空，请先新增课程！");
		else
		{
			Scanner in=new Scanner(System.in);
		
		String choose=in.nextLine();
			switch(choose)
			{
			
			      case "1":
			
				     System.out.println("课程号              "+"课程名           "+"任教教师        "+"开设学院             ");
				    
			       for(Map.Entry<String, Course>entry:map.entrySet())
			         {
				  
			    	   if(u.checkUsertype()==1)
				          System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
			    	   else if(u.department.equals(entry.getValue().coursetype)&&u.checkUsertype()==2)//普通管理员
			    		   System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype); 
			    	   else if(u.checkUsertype()==3&&entry.getValue().courseTeacherId.equals(u.loginId))
			    		   System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype); 
			    	  
			         }
				     
				    	 
			       System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
			            String choose2=in.nextLine();
			               switch(choose2)
			                     {
			                         case "1":Admin.seeCourse(u);break;
			                         case "2":UserUi.AdminManagebar(u);break;
			                         case "3":new UserUi();break;
			                         default:
			                        	 System.out.println("无效输入,自动返回上级菜单!");
			                        
			                        	 Admin.seeCourse(u);
			                        	 
			                     }
			           break;
			       case "2":
				           System.out.println("请输入查询的课程的课程号:");    //管理员只能查看本学院的课和教师只能查看自己任教的课
				          String courseid=in.nextLine();
				        for(Entry<String, Course> entry:map.entrySet())
				         {
					        if(entry.getKey().equals(courseid))
					         {
					        	System.out.println("课程号              "+"课程名           "+"任教教师        "+"开设学院        ");
					        	if(u.checkUsertype()==1)
						        System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
					        	if(u.checkUsertype()==2&&entry.getKey().equals(courseid)&&entry.getValue().coursetype.equals(u.department))
					        		System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
					        	if(u.checkUsertype()==3&&entry.getKey().equals(courseid)&&entry.getValue().courseTeacherId.equals(u.loginId))
					        		System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
					         }
				          }
				        System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
			            String choose3=in.nextLine();
			               switch(choose3)
			                     {
			                         case "1":Admin.seeCourse(u);break;
			                         case "2":UserUi.AdminManagebar(u);break;
			                         case "3":new UserUi();break;
			                         default:
			                        	 System.out.println("无效输入,自动返回上级菜单!");
			                        
			                        	 Admin.seeCourse(u);
			                        	 
			                     }
				        break;
			       default:
			       
	              	 System.out.println("无效输入,自动返回上级菜单!");
	              
	              	 Admin.seeStudent(u);
			    	   
			 }
		}
	}
	
	public void deleteCourse(User u) {
		boolean b=false;
		System.out.println("请输入需要删除指定课程号:");
		HashMap<String,Course> map=Course.ReadCourseFromFile();
		Scanner in=new Scanner(System.in);
		String courseid=in.nextLine();
		
		for(Iterator<Map.Entry<String, Course>>it=map.entrySet().iterator();it.hasNext();)
		{
			Map.Entry<String,Course> item=it.next();
			
			if(item.getKey().equals(courseid))
			{
				
				it.remove();
				System.out.println("课程"+courseid+"删除成功");
				b=true;
			}
		}
		if(b==false)
		System.out.println("查询课程不存在！");
		Course.WriteCourseToFile(map);
		System.out.println("是否继续？y-继续 n-返回上级菜单 x-注销登录");
		String choose=in.nextLine();
		switch(choose)
		{
		case "y":deleteCourse(u);break;
		case "n":try {
				UserUi.AdminCourseManagebar(u);
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		break;
		case "x":
			System.out.println("注销成功！再见！");
		     try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		     default:
		    	 System.out.println("输入有误,自动返回上级菜单！");
			try {
				UserUi.AdminCourseManagebar(u);
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		}
			
		
		
	}
	public static void changeCourse(User u) {
		System.out.println("请输入需要修改指定课程号:");
		HashMap<String,Course> map=Course.ReadCourseFromFile();
		Scanner in=new Scanner(System.in);
		String courseid=in.nextLine();
		System.out.print("请输入课程名：\n");
		String coursename=in.nextLine();
		System.out.println("请输入任教老师工号：");
		String courseteacherid=in.nextLine();
		System.out.println("请输入开设学院：");
		String coursetype=in.nextLine();
		
		map.put(courseid,new Course(courseid,coursename,courseteacherid,coursetype));
		Course.WriteCourseToFile(map);
		
	}
	public boolean addAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException{
		boolean b=false;
		System.out.print("请输入增加普通管理员工号(如果为学院部门人以“admin+*”形式,为教师以“teach+*”形式):\n");
		Scanner in=new Scanner(System.in);
		String loginid=in.nextLine();
		if(loginid.length()<5)//防止字符越界异常
			loginid="      ";
			
		while(!(loginid.substring(0, 5).equals("admin")||loginid.substring(0, 5).equals("teach")))
				{
			         System.out.println("工号形式输入错误,请重新输入！");
			         loginid=in.nextLine();
			         if(loginid.length()<5)
			 			loginid="      ";
				}
		System.out.print("请输入管理员姓名：\n");
		String name=in.nextLine();
		System.out.println("请输入管理员性别：");
		String sex=in.nextLine();
		System.out.println("请输入管理员年龄：");
		String age=in.nextLine();
		System.out.println("请输入管理员所属部门 ：");
		String department=in.nextLine();
		
		b=new User().WriteUser(new Admin(loginid,name,sex,age,department));
		System.out.println("是否继续增加管理员？y/n\n输入y则继续增加管理员,n则自动返回上级菜单!");
		String choose=in.nextLine();
		while(!(choose.equals("y")||choose.equals("n")))
		{
		   
			 
				  System.out.println("输入有误，请重新输入!");
				  choose=in.nextLine();
		   }
		switch(choose)
		   {
		   case "y":
			   addAdmin(u);break;
		   case "n":
			   UserUi.AdminManagebar(u);break;
		   }
		
			return b;
	
		
	}
	public static void seeAllAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException//查询所有管理员
	{
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		System.out.println("工号              "+"姓名           "+"性别        "+"年龄             "+"所属部门            "+"账户密码");
	       for(Map.Entry<String, User>entry:map.entrySet())
	         {
		        if(!entry.getKey().equals("sysadmin"))
		        	 //System.out.print(entry.getValue().usertype);
		        if(entry.getValue().loginId.substring(0, 5).equals("admin")||entry.getValue().loginId.substring(0, 5).equals("teach"))
		          System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().department+"     "+entry.getValue().password);
	         }
	       System.out.println("1-返回上级菜单\n2-返回主菜单\n3-注销登录");
	            String choose2=in.nextLine();
	               switch(choose2)
	                     {
	                         case "1":Admin.seeAdmin(u);break;
	                         case "2":UserUi.AdminManagebar(u);break;
	                         case "3":new UserUi();break;
	                         default:
	                        	 System.out.println("无效输入,自动返回上级菜单!");
	                        
	                        	 Admin.seeAdmin(u);
	                        	 
	                     }
		
	}
	public static void seeOneAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		HashMap<String,User> map=User.ReadUserFromFile();
		System.out.println("请输入查询工号(工号形式“admin+任意字符或teach+任意字符):");
        Scanner  in=new Scanner(System.in);
        String loginid=in.nextLine();
        while(!(loginid.substring(0, 5).equals("admin")||loginid.substring(0, 5).equals("teach")))
			{
		         System.out.println("工号形式输入错误,请重新输入！");
		         loginid=in.nextLine();
		         if(loginid.length()<5)
		 			loginid="      ";
			}
      for(Map.Entry<String, User>entry:map.entrySet())
       {
	        if(entry.getKey().equals(loginid))
	         {
	        	System.out.println("工号              "+"姓名           "+"性别        "+"年龄             "+"所属部门            "+"账户密码        ");
		        System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().department+"     "+entry.getValue().password);
	         }
	        
        }
      System.out.println("是否继续查询管理员？y/n\n输入y则继续查询,n则返回上级菜单!");
		String choose=in.nextLine();
		while(!(choose.equals("y")||choose.equals("n")))
		{
		   
			 
				  System.out.println("输入有误，请重新输入!");
				  choose=in.nextLine();
		   }
		switch(choose)
		   {
		   case "y":
			   seeOneAdmin(u);break;
		   case "n":
			   seeAdmin(u);break;
		   }
     
	}
	
	public static void seeAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("请输入查看选项: \n 1-查看所有管理员 \n 2-查询指定管理员\n 3-返回上级菜单\n 4-返回主菜单");
		
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
	
		switch(choose)
		{
		
		      case "1":
		          seeAllAdmin(u);
			     
		           break;
		       case "2":
			           seeOneAdmin(u);
			        break;
		       case "3":
		    	   UserUi.AdminManagebar(u);
		    	   
		    	case "4":UserUi.AdminManagebar(u);break;
		    	default:
              	 System.out.println("无效输入,请重新选择!");
              
              	 Admin.seeAdmin(u);
		    	   
		 }
	}
	
	public void deleteAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("请输入需要删除指定工号:");
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		String loginid=in.nextLine();
		
		for(Iterator<Map.Entry<String, User>>it=map.entrySet().iterator();it.hasNext();)
		{
			Map.Entry<String,User> item=it.next();
			
			if(item.getKey().equals(loginid))
			{
				
				it.remove();
				User.WriteUserToFile(map);
				System.out.println("工号"+loginid+"管理员删除成功");
				
			}
		}
		System.out.println("是否继续删除管理员？y/n\n输入y则继续查询,n则返回上级菜单!");
		String choose=in.nextLine();
		while(!(choose.equals("y")||choose.equals("n")))
		{
		   
			 
				  System.out.println("输入有误，请重新输入!");
				  choose=in.nextLine();
		   }
		switch(choose)
		   {
		   case "y":
			   deleteAdmin(u);break;
		   case "n":
			   UserUi.AdminManagebar(u);break;
		   }
		
		
			
			
		
		
		
	}
	public void changeAdmin(User u) {//略
		// TODO Auto-generated method stub
		
	}
	public void changeAdminPassword(User u) {//略
		// TODO Auto-generated method stub
		
	}
		

}