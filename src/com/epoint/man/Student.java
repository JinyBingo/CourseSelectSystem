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
		this.usertype="ѧ��";
		this.major=mj;
		this.password=loginId;//��ѧ���˻���ʼ������Ϊ�û���
		
	}
	
	Student(String id,String name,String sex,String age,String mj,String pw)
	{
		super();
		this.loginId=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.usertype="ѧ��";
		this.major=mj;
		this.password=pw;//��ѧ���˻���ʼ������Ϊ�û���
		this.usertype="ѧ��";
	}

	

	public static void seeSelectedCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		   
		   System.out.println(u.loginId+"ͬѧ,���!���Ѿ�ѡ��γ�����:\n �γ���                    �γ���                 �ν̽�ʦ����            �γ�����");//�б�Ϊ����δѡ�Σ����ﲻ�����߼���ʾ
		   HashMap<String,Course> map=readSelectedCourse(u.loginId);
		   for(Map.Entry<String, Course>entry:map.entrySet())
		   {
			   System.out.println(entry.getValue());
		   }
		   System.out.println("����\n 1-�����ϼ��˵�\nx-ע����¼");
		   Scanner in=new Scanner(System.in);
		   String choose=in.nextLine();
		   switch(choose)
		   {
		   case "1":UserUi.studentMunuBar(u);break;
		   case "x":System.out.println("ע����¼�ɹ����ټ���");
		   new UserUi();break;
		   default:
			   System.out.println("���������Զ��ص��ϼ��˵���");
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
		      System.out.println(u.loginId+"ͬѧ�����!�㻹����ѡ�Ŀγ�����:\n  �γ̺�                �γ���              �ν̽�ʦ����             �γ�����");
		      HashMap<String,Course> map=CanSelectCourse(u);
		      
		      for(Map.Entry<String, Course>entry:map.entrySet())
		      {
		    	  System.out.println(entry.getValue());
		      }
		      System.out.println("����\nf-�����ϼ��˵�\nx-�˳���¼");
		      Scanner in=new Scanner(System.in);
		      String choose=in.nextLine();
		      switch(choose)
		      {
		      case "f":UserUi.studentMunuBar(u);
		      break;
		      case "x":System.out.println("�˳���¼�ɹ�,�ټ���");
		      new UserUi();
		      break;
		      default:
		    	  System.out.println("���������Զ������ϼ��˵���");
		    	  UserUi.studentMunuBar(u);
		      }
		
	}

	public static void selectCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		 System.out.println(u.loginId+"ͬѧ�����!�㻹����ѡ�Ŀγ�����:\n  �γ̺�                �γ���              �ν̽�ʦ����             �γ�����");
	      HashMap<String,Course> map=CanSelectCourse(u);
	      
	      for(Map.Entry<String, Course>entry:map.entrySet())
	      {
	    	  System.out.println(entry.getValue());
	      }
		 System.out.println("����������б�������Ҫѡ�Ŀγ̺�:");
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
				 System.out.println(u.loginId+"ͬѧ,����ѡ��"+"�γ̺�Ϊ"+entry.getKey()+"�γ���Ϊ"+entry.getValue().courseName+"�Ŀγ�!");
				 
			 }
		 }
		 System.out.println("�Ƿ����ѡ�Σ� \ny-���� f-�����ϼ��˵� x-ע����¼");
		 String choose=in.nextLine();
		 switch(choose)
		 {
		 case "y":selectCourse(u);break;
		 case "f":UserUi.studentMunuBar(u);break;
		 case "x":System.out.println("ע����¼�ɹ����ټ���");
		 new UserUi();break;
		 default:
			 System.out.println("���������Զ������ϼ��˵���");
			 UserUi.studentMunuBar(u);
		 }
		 
		
	}

	public static void changeCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println(u.loginId+"ͬѧ,���!���Ѿ�ѡ��γ�����:\n �γ���                    �γ���                 �ν̽�ʦ����            �γ�����");//�б�Ϊ����δѡ�Σ����ﲻ�����߼���ʾ
		   HashMap<String,Course> map1=readSelectedCourse(u.loginId);
		   for(Map.Entry<String, Course>entry:map1.entrySet())
		   {
			   System.out.println(entry.getValue());
		   }
		    System.out.println("���������ѡ�Ŀγ����,������Ҫɾ���Ŀγ̺�:");
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
		            		System.out.println("�γ�"+courseid+"ɾ���ɹ�!");
		            	}
		            }
		            saveSelectedCourseToFile(map);
		            System.out.println("�Ƿ����ɾ���γ̣� \ny-���� f-�����ϼ��˵� x-ע����¼");
		   		 String choose=in.nextLine();
		   		 switch(choose)
		   		 {
		   		 case "y":changeCourse(u);break;
		   		 case "f":UserUi.studentMunuBar(u);break;
		   		 case "x":System.out.println("ע����¼�ɹ����ټ���");
		   		 new UserUi();break;
		   		 default:
		   			 System.out.println("���������Զ������ϼ��˵���");
		   			 UserUi.studentMunuBar(u);
		   		 }
	}
   
	public static void changePassword(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		HashMap<String,User> map=User.ReadUserFromFile();
		System.out.println("�����������:");
		Scanner in=new Scanner(System.in);
		String password1=in.nextLine();
		System.out.println("�������޸ĺ�����:");
		String password2=in.nextLine();
		System.out.println("���ٴ������޸ĺ�����:");
		String password3=in.nextLine();
		for(Map.Entry<String, User>entry:map.entrySet())
		{
			if(entry.getKey().equals(u.loginId))
			{
				if(password2.equals(password3)&&password1.equals(entry.getValue().password))
				{
					map.put(u.loginId,new Student(u.loginId,entry.getValue().name,entry.getValue().sex,entry.getValue().age,entry.getValue().major,password2));
				    User.WriteUserToFile(map);
			         System.out.println(entry.getValue().name+"ͬѧ����������޸ĳɹ�,���ε�¼�ѹ��������µ�¼!");
			         new UserUi();
			       
				}
				else
				{
					System.out.println("�����������������룡");
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
    			
    			//��������
    		}
    	HashMap<String, Course> map=new HashMap<String,Course>();
    	
    			FileInputStream fin;
    			try {               //�����ļ������ļ�β�쳣���ļ���ɾ��������ݵ��������ֹ�쳣���׳��������߳̽���
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
