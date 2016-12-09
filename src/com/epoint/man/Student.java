package com.epoint.man;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.epoint.logic.Course;
import com.epoint.ui.UserUi;

public class Student extends User implements Serializable{
	public static final long serialVersionUID = 1l;
	
	
	
	Student(String id,String name,String sex,String age,String mj)
	{
		super();
		this.loginId=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.usertype="学生";
		this.major=mj;
		this.password=loginId;//将学生账户初始密码设为用户名
		
	}
	
	Student(String id,String name,String sex,String age,String mj,String pw)
	{
		super();
		this.loginId=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.usertype="学生";
		this.major=mj;
		this.password=pw;//将学生账户初始密码设为用户名
		this.usertype="学生";
	}

	

	public static void seeSelectedCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		   
		   System.out.println(u.loginId+"同学,你好!你已经选择课程如下:\n 课程码                    课程名                 任教教师工号            课程类型");//列表为空则未选课，这里不再做逻辑显示
		   HashMap<String,Course> map=readSelectedCourse(u.loginId);
		   for(Map.Entry<String, Course>entry:map.entrySet())
		   {
			   System.out.println(entry.getValue());
		   }
		   System.out.println("输入\n 1-返回上级菜单\nx-注销登录");
		   Scanner in=new Scanner(System.in);
		   String choose=in.nextLine();
		   switch(choose)
		   {
		   case "1":UserUi.studentMunuBar(u);break;
		   case "x":System.out.println("注销登录成功！再见！");
		   new UserUi();break;
		   default:
			   System.out.println("输入有误，自动回到上级菜单！");
			   UserUi.studentMunuBar( u);	   
		   }
		
	}

	public static HashMap<String,Course> CanSelectCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		    HashMap<String,Course> map1=Course.ReadCourseFromFile();
		    HashMap<String,Course> map2=readSelectedCourse(u.loginId);
		   // HashMap<String,Course> map3=new HashMap<String,Course>();
		  
		    if(map2.size()==0)
		    	map1=map1;
		    
		    for(Map.Entry<String, Course>entry2:map2.entrySet())
		    {
		    	for(Iterator<Entry<String, Course>>it=map1.entrySet().iterator();it.hasNext();)
				{
					Entry<String, Course> item=it.next();
		    		
		    		
		    		if(entry2.getValue().courseId.equals(item.getKey()))
		    			   it.remove();
		    		
		    	}
		    }
		    return map1; 
		
	}
	public static void seeCanSelectCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		      System.out.println(u.loginId+"同学，你好!你还可以选的课程如下:\n  课程号                课程名              任教教师工号             课程类型");
		      HashMap<String,Course> map=CanSelectCourse(u);
		      
		      for(Map.Entry<String, Course>entry:map.entrySet())
		      {
		    	  System.out.println(entry.getValue());
		      }
		      System.out.println("输入\nf-返回上级菜单\nx-退出登录");
		      Scanner in=new Scanner(System.in);
		      String choose=in.nextLine();
		      switch(choose)
		      {
		      case "f":UserUi.studentMunuBar(u);
		      break;
		      case "x":System.out.println("退出登录成功,再见！");
		      new UserUi();
		      break;
		      default:
		    	  System.out.println("输入有误，自动返回上级菜单！");
		    	  UserUi.studentMunuBar(u);
		      }
		
	}

	public static void selectCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		 System.out.println(u.loginId+"同学，你好!你还可以选的课程如下:\n  课程号                课程名              任教教师工号             课程类型");
	      HashMap<String,Course> map=CanSelectCourse(u);
	      
	      for(Map.Entry<String, Course>entry:map.entrySet())
	      {
	    	  System.out.println(entry.getValue());
	      }
		 System.out.println("请根据上面列表输入你要选的课程号:");
		 Scanner in=new Scanner(System.in);
		 String courseid=in.nextLine();
		 HashMap<String,Course> map1=ReadSelectedCourseFromFile();
		 HashMap<String,Course> map2=Course.ReadCourseFromFile();
		 for(Map.Entry<String, Course>entry:map2.entrySet())
		 {
			 if(entry.getKey().equals(courseid))
			 {
				 String loginidAndcourse=u.loginId+entry.getKey();
				 map1.put(loginidAndcourse,entry.getValue());
				 saveSelectedCourseToFile(map1);
				 System.out.println(u.loginId+"同学,你已选了"+"课程号为"+entry.getKey()+"课程名为"+entry.getValue().courseName+"的课程!");
				 
			 }
		 }
		 System.out.println("是否继续选课？ \ny-继续 f-返回上级菜单 x-注销登录");
		 String choose=in.nextLine();
		 switch(choose)
		 {
		 case "y":selectCourse(u);break;
		 case "f":UserUi.studentMunuBar(u);break;
		 case "x":System.out.println("注销登录成功！再见！");
		 new UserUi();break;
		 default:
			 System.out.println("输入有误，自动返回上级菜单！");
			 UserUi.studentMunuBar(u);
		 }
		 
		
	}

	public static void changeCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println(u.loginId+"同学,你好!你已经选择课程如下:\n 课程码                    课程名                 任教教师工号            课程类型");//列表为空则未选课，这里不再做逻辑显示
		   HashMap<String,Course> map1=readSelectedCourse(u.loginId);
		   for(Map.Entry<String, Course>entry:map1.entrySet())
		   {
			   System.out.println(entry.getValue());
		   }
		    System.out.println("请根据你已选的课程情况,输入需要删除的课程号:");
		    		Scanner in=new Scanner(System.in);
		            String courseid=in.nextLine();
		            HashMap<String,Course> map=ReadSelectedCourseFromFile();
		            for(Iterator<Map.Entry<String, Course>>it=map.entrySet().iterator();it.hasNext();)
		    		{
		    			Entry<String, Course> item=it.next();
		    		   //System.out.println(item.getKey().substring(u.loginId.length(),item.getKey().length()));
		    			
		            	if(item.getKey().substring(u.loginId.length(),item.getKey().length()).equals(courseid))
		            	{
		            		it.remove();
		            		System.out.println("课程"+courseid+"删除成功!");
		            	}
		            }
		            saveSelectedCourseToFile(map);
		            System.out.println("是否继续删除课程？ \ny-继续 f-返回上级菜单 x-注销登录");
		   		 String choose=in.nextLine();
		   		 switch(choose)
		   		 {
		   		 case "y":changeCourse(u);break;
		   		 case "f":UserUi.studentMunuBar(u);break;
		   		 case "x":System.out.println("注销登录成功！再见！");
		   		 new UserUi();break;
		   		 default:
		   			 System.out.println("输入有误，自动返回上级菜单！");
		   			 UserUi.studentMunuBar(u);
		   		 }
	}
   
	public static void changePassword(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		HashMap<String,User> map=User.ReadUserFromFile();
		System.out.println("请输入旧密码:");
		Scanner in=new Scanner(System.in);
		String password1=in.nextLine();
		System.out.println("请输入修改后密码:");
		String password2=in.nextLine();
		System.out.println("请再次输入修改后密码:");
		String password3=in.nextLine();
		for(Map.Entry<String, User>entry:map.entrySet())
		{
			if(entry.getKey().equals(u.loginId))
			{
				if(password2.equals(password3)&&password1.equals(entry.getValue().password))
				{
					map.put(u.loginId,new Student(u.loginId,entry.getValue().name,entry.getValue().sex,entry.getValue().age,entry.getValue().major,password2));
				    User.WriteUserToFile(map);
			         System.out.println(entry.getValue().name+"同学你的密码已修改成功,本次登录已过期请重新登录!");
			         new UserUi();
			       
				}
				else
				{
					System.out.println("输入有误，请重新输入！");
					changePassword(u);
				}
			}
		}
		
		
	}

	public static void saveSelectedCourseToFile(HashMap<String,Course> map) throws FileNotFoundException
	{
		File f=new File("studentSelectedCourse.txt");
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
	    FileOutputStream fis=new FileOutputStream(f);
	    try {
			ObjectOutputStream os=new ObjectOutputStream(fis);
			os.writeObject(map);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	
}
	 public static HashMap<String,Course> readSelectedCourse(String loginid) throws FileNotFoundException, ClassNotFoundException, IOException
     {
     	Course course=null;
     	HashMap<String,Course> map=ReadSelectedCourseFromFile();
     	HashMap<String,Course> map2=new HashMap();
     	//Iterator iter=(Iterator) map.keySet();
     	for(Map.Entry<String, Course>entry:map.entrySet())
     	{
     		  
     		if(loginid.equals(entry.getKey().substring(0,loginid.length())))
     		     map2.put(entry.getKey(),entry.getValue());
     	}
     	    return map2;
     	
     }
	public static HashMap<String,Course> ReadSelectedCourseFromFile() 
    {
    	
    	File f=new File("studentSelectedCourse.txt");
    	if(!f.exists())
    		try {
    			f.createNewFile();
    		} catch (IOException e) {
    			
    			//不做处理
    		}
    	HashMap<String, Course> map=new HashMap<String,Course>();
    	
    			FileInputStream fin;
    			try {               //捕获文件读到文件尾异常及文件被删或被清空数据的情况，防止异常被抛出导致主线程结束
    				ObjectInputStream inp;
    				fin = new FileInputStream(f);
    			
    				inp=new ObjectInputStream(fin);
    			
    			   map=(HashMap<String, Course>) inp.readObject();
    			   inp.close();
    			} catch (FileNotFoundException e) {
    				
    				e.printStackTrace();
    			} catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				//e.printStackTrace();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				//e.printStackTrace();
    			}
    			finally{
    		     
    			}
    	
    		return map;
    	
    }

	
}
