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
		
		this.usertype="��ͨ����Ա";
	}
	public Admin(String loginid,String name,String sex,String age,String department)
	{
		//super();
		this.loginId=loginid;
		this.password=loginid;//��ʼ����Ϊ����
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.department=department;
		if(loginid.substring(0,5).equals("admin"))
		this.usertype="��ͨ����Ա";
		else if(loginid.substring(0, 5).equals("teach"))
			this.usertype="��ʦ";
		
	}
	

	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public static boolean addStudent() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		
		System.out.print("����������ѧ��ѧ��(�����ֿ�ʼ)��\n");
		Scanner in=new Scanner(System.in);
		String sno=in.nextLine();
	  System.out.print("������ѧ��������\n");
		String name=in.nextLine();
		 System.out.println("������ѧ���Ա�");
		  String sex="";
		//while(!(sex.equals("��")||sex.equals("Ů")))
				//{
			System.out.println("�Ա�ֻ�����л���Ů��");
	sex=in.nextLine();
				//}
		System.out.println("������ѧ�����䣺");
		 String age=in.nextLine();
		 System.out.println("������ ѧ��רҵ ��");
		   String major=in.nextLine();
		
		  return new User().WriteUser(new Student(sno,name,sex,age,major));
	}
	//public static boolean studentQuery()
	//{
		//HashMap<String,User> map=;
	public static void seeStudent(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("������鿴ѡ��: \n 1-�鿴����ѧ�� \n 2-��ѯָ��ѧ��");
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
	if(u.checkUsertype()==1)
	{
		switch(choose)
		{
		
		      case "1":
		
			     System.out.println("ѧ��              "+"����           "+"�Ա�        "+"����             "+"רҵ            "+"�˻�����");
		       for(Map.Entry<String, User>entry:map.entrySet())
		         {
			  
			         if(entry.getValue().usertype.equals("ѧ��"))
			          System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     "+entry.getValue().password);
		         }
		       System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
		            String choose2=in.nextLine();
		               switch(choose2)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
		           break;
		       case "2":
			           System.out.println("�������ѯ��ѧ����ѧ��:");
			          String sno=in.nextLine();
			        for(Map.Entry<String, User>entry:map.entrySet())
			         {
				        if(entry.getKey().equals(sno))
				         {
				        	System.out.println("ѧ��              "+"����           "+"�Ա�        "+"����             "+"רҵ            "+"�˻�����        ");
					        System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     "+entry.getValue().password);
				         }
			          }
			        System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
		            String choose3=in.nextLine();
		               switch(choose3)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
			        break;
		       default:
		       
              	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
              
              	 Admin.seeStudent(u);
		    	   
		 }
	}
	else if(u.checkUsertype()==2)//����Աû�� ��ѧ���˻������Ȩ��
	{
		switch(choose)
		{
		
		      case "1":
		
			     System.out.println("ѧ��              "+"����           "+"�Ա�        "+"����             "+"רҵ            ");
		       for(Map.Entry<String, User>entry:map.entrySet())
		         {
			  
			         if(entry.getValue().usertype.equals("ѧ��"))
			          System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     ");
		         }
		       System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
		            String choose2=in.nextLine();
		               switch(choose2)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
		           break;
		       case "2":
			           System.out.println("�������ѯ��ѧ����ѧ��:");
			          String sno=in.nextLine();
			        for(Map.Entry<String, User>entry:map.entrySet())
			         {
				        if(entry.getKey().equals(sno))
				         {
				        	System.out.println("ѧ��              "+"����           "+"�Ա�        "+"����             "+"רҵ            ");
					        System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().major+"     ");
				         }
			          }
			        System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
		            String choose3=in.nextLine();
		               switch(choose3)
		                     {
		                         case "1":Admin.seeStudent(u);break;
		                         case "2":UserUi.AdminManagebar(u);break;
		                         case "3":new UserUi();break;
		                         default:
		                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
		                        
		                        	 Admin.seeStudent(u);
		                        	 
		                     }
			        break;
		       default:
		       
              	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
              
              	 Admin.seeStudent(u);
		    	   
		 }
	}
		
		
	}
	public static void  deleteStudent(User u) {
		boolean b=false;
		System.out.println("��������Ҫɾ��ָ��ѧ����ѧ��:");
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
				System.out.println("ѧ��"+loginid+"ɾ���ɹ�");
				User.WriteUserToFile(map);
				
				System.out.println("�Ƿ������y-��  n-�����ϼ��˵� x-ע����½");
				
				String choose=in.nextLine();
				switch(choose)
				{
				case "y":deleteStudent(u);break;
				case "n":UserUi.adminStudentManagebar(u);break;
				case "x":System.out.println("ע����¼�ɹ����ټ���");
					try {
						new UserUi();
					} catch (ClassNotFoundException | IOException e) {
						
						e.printStackTrace();
					}
					break;
					default:
						System.out.println("���������Զ������ϼ��˵���");
						UserUi.adminStudentManagebar(u);
				}
			}
			
			
		}
		
		
		if(b==false)
		{
			System.out.println("ѧ���������޷�ɾ��!����y-����ɾ��  ������-���ص��ϼ��˵���");
			String choose2=in.nextLine();
			
			if(choose2.equals("y"))
			deleteStudent(u);
			else
				UserUi.adminStudentManagebar(u);
				
		}	
		
			
		
		
	}
	public static void changeStudent(User u) {
		
		System.out.println("��������Ҫ�޸�ָ��ѧ����ѧ��:");//���ﲻ�����޸�ѧ���Ƿ����
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		String loginid=in.nextLine();
		System.out.print("������ѧ��������\n");
		String name=in.nextLine();
		System.out.println("������ѧ���Ա�");
		String sex=in.nextLine();
		System.out.println("������ѧ�����䣺");
		String age=in.nextLine();
		System.out.println("������ ѧ��רҵ ��");
		String major=in.nextLine();
		map.put(loginid,new Student(loginid,name,sex,age,major));
		WriteUserToFile(map);
		System.out.println("�޸ĳɹ����Ƿ���� y-���� n-�����ϼ��Ų˵� x-ע����¼");
		String choose=in.nextLine();
		switch(choose)
		{
		case "y":changeStudent(u);break;
		case "n":UserUi.adminStudentManagebar(u);break;
		case "x":System.out.println("ע����¼�ɹ����ټ���");
			try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
			default:
			System.out.println("���������Զ������ϼ��˵���");
			UserUi.adminStudentManagebar(u);
		}
	}
	public void changeStudentPassword(User u) {
		
		System.out.println("��������Ҫ�޸�����ָ��ѧ����ѧ��:");
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		System.out.println("�������޸ĺ�����:");
		String password=in.nextLine();
		String loginid=in.nextLine();
		for(Map.Entry<String, User>entry:map.entrySet())
		{
			if(entry.getKey().equals(loginid))
			{
				map.put(loginid,new Student(loginid,entry.getValue().name,entry.getValue().sex,entry.getValue().age,entry.getValue().major,password));
				WriteUserToFile(map); 
			    System.out.println(loginid+"ѧ�������޸ĳɹ�");
			}
		}
		
		
	}
	
	public static boolean addCourse(User u)  {
		System.out.print("���������ӿγ̺ţ�\n");//���ﲻ�ٿ��ǿγ��Ƿ����
		Scanner in=new Scanner(System.in);
		String courseid=in.nextLine();
		System.out.print("������γ�����\n");
		String coursename=in.nextLine();
		System.out.println("������γ��ο���ʦ���ţ�");
		String courseteacher=in.nextLine();
		System.out.println("������γ����ͣ�");
		String coursetype=in.nextLine();
		
		return Course.WriteCourse(new Course(courseid,coursename,courseteacher,coursetype)); 
		
	}
	public static void seeCourse(User u) throws FileNotFoundException, ClassNotFoundException, IOException 
	{
		System.out.println("������鿴ѡ��: \n 1-�鿴���пγ� \n 2-��ѯָ���γ�");//�����ѯ��ʾ�б�Ϊ�����ʾ�γ̲�����
		HashMap<String,Course> map=Course.ReadCourseFromFile();
		if(map.size()==0)
			System.out.println("�γ��б�Ϊ�գ����������γ̣�");
		else
		{
			Scanner in=new Scanner(System.in);
		
		String choose=in.nextLine();
			switch(choose)
			{
			
			      case "1":
			
				     System.out.println("�γ̺�              "+"�γ���           "+"�ν̽�ʦ        "+"����ѧԺ             ");
				    
			       for(Map.Entry<String, Course>entry:map.entrySet())
			         {
				  
			    	   if(u.checkUsertype()==1)
				          System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
			    	   else if(u.department.equals(entry.getValue().coursetype)&&u.checkUsertype()==2)//��ͨ����Ա
			    		   System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype); 
			    	   else if(u.checkUsertype()==3&&entry.getValue().courseTeacherId.equals(u.loginId))
			    		   System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype); 
			    	  
			         }
				     
				    	 
			       System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
			            String choose2=in.nextLine();
			               switch(choose2)
			                     {
			                         case "1":Admin.seeCourse(u);break;
			                         case "2":UserUi.AdminManagebar(u);break;
			                         case "3":new UserUi();break;
			                         default:
			                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
			                        
			                        	 Admin.seeCourse(u);
			                        	 
			                     }
			           break;
			       case "2":
				           System.out.println("�������ѯ�Ŀγ̵Ŀγ̺�:");    //����Աֻ�ܲ鿴��ѧԺ�Ŀκͽ�ʦֻ�ܲ鿴�Լ��ν̵Ŀ�
				          String courseid=in.nextLine();
				        for(Entry<String, Course> entry:map.entrySet())
				         {
					        if(entry.getKey().equals(courseid))
					         {
					        	System.out.println("�γ̺�              "+"�γ���           "+"�ν̽�ʦ        "+"����ѧԺ        ");
					        	if(u.checkUsertype()==1)
						        System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
					        	if(u.checkUsertype()==2&&entry.getKey().equals(courseid)&&entry.getValue().coursetype.equals(u.department))
					        		System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
					        	if(u.checkUsertype()==3&&entry.getKey().equals(courseid)&&entry.getValue().courseTeacherId.equals(u.loginId))
					        		System.out.println(entry.getKey()+"     "+entry.getValue().courseName+"    "+entry.getValue().courseTeacherId+"    "+entry.getValue().coursetype);
					         }
				          }
				        System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
			            String choose3=in.nextLine();
			               switch(choose3)
			                     {
			                         case "1":Admin.seeCourse(u);break;
			                         case "2":UserUi.AdminManagebar(u);break;
			                         case "3":new UserUi();break;
			                         default:
			                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
			                        
			                        	 Admin.seeCourse(u);
			                        	 
			                     }
				        break;
			       default:
			       
	              	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
	              
	              	 Admin.seeStudent(u);
			    	   
			 }
		}
	}
	
	public void deleteCourse(User u) {
		boolean b=false;
		System.out.println("��������Ҫɾ��ָ���γ̺�:");
		HashMap<String,Course> map=Course.ReadCourseFromFile();
		Scanner in=new Scanner(System.in);
		String courseid=in.nextLine();
		
		for(Iterator<Map.Entry<String, Course>>it=map.entrySet().iterator();it.hasNext();)
		{
			Map.Entry<String,Course> item=it.next();
			
			if(item.getKey().equals(courseid))
			{
				
				it.remove();
				System.out.println("�γ�"+courseid+"ɾ���ɹ�");
				b=true;
			}
		}
		if(b==false)
		System.out.println("��ѯ�γ̲����ڣ�");
		Course.WriteCourseToFile(map);
		System.out.println("�Ƿ������y-���� n-�����ϼ��˵� x-ע����¼");
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
			System.out.println("ע���ɹ����ټ���");
		     try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		     default:
		    	 System.out.println("��������,�Զ������ϼ��˵���");
			try {
				UserUi.AdminCourseManagebar(u);
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		}
			
		
		
	}
	public static void changeCourse(User u) {
		System.out.println("��������Ҫ�޸�ָ���γ̺�:");
		HashMap<String,Course> map=Course.ReadCourseFromFile();
		Scanner in=new Scanner(System.in);
		String courseid=in.nextLine();
		System.out.print("������γ�����\n");
		String coursename=in.nextLine();
		System.out.println("�������ν���ʦ���ţ�");
		String courseteacherid=in.nextLine();
		System.out.println("�����뿪��ѧԺ��");
		String coursetype=in.nextLine();
		
		map.put(courseid,new Course(courseid,coursename,courseteacherid,coursetype));
		Course.WriteCourseToFile(map);
		
	}
	public boolean addAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException{
		boolean b=false;
		System.out.print("������������ͨ����Ա����(���ΪѧԺ�������ԡ�admin+*����ʽ,Ϊ��ʦ�ԡ�teach+*����ʽ):\n");
		Scanner in=new Scanner(System.in);
		String loginid=in.nextLine();
		if(loginid.length()<5)//��ֹ�ַ�Խ���쳣
			loginid="      ";
			
		while(!(loginid.substring(0, 5).equals("admin")||loginid.substring(0, 5).equals("teach")))
				{
			         System.out.println("������ʽ�������,���������룡");
			         loginid=in.nextLine();
			         if(loginid.length()<5)
			 			loginid="      ";
				}
		System.out.print("���������Ա������\n");
		String name=in.nextLine();
		System.out.println("���������Ա�Ա�");
		String sex=in.nextLine();
		System.out.println("���������Ա���䣺");
		String age=in.nextLine();
		System.out.println("���������Ա�������� ��");
		String department=in.nextLine();
		
		b=new User().WriteUser(new Admin(loginid,name,sex,age,department));
		System.out.println("�Ƿ�������ӹ���Ա��y/n\n����y��������ӹ���Ա,n���Զ������ϼ��˵�!");
		String choose=in.nextLine();
		while(!(choose.equals("y")||choose.equals("n")))
		{
		   
			 
				  System.out.println("������������������!");
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
	public static void seeAllAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException//��ѯ���й���Ա
	{
		HashMap<String,User> map=User.ReadUserFromFile();
		Scanner in=new Scanner(System.in);
		System.out.println("����              "+"����           "+"�Ա�        "+"����             "+"��������            "+"�˻�����");
	       for(Map.Entry<String, User>entry:map.entrySet())
	         {
		        if(!entry.getKey().equals("sysadmin"))
		        	 //System.out.print(entry.getValue().usertype);
		        if(entry.getValue().loginId.substring(0, 5).equals("admin")||entry.getValue().loginId.substring(0, 5).equals("teach"))
		          System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().department+"     "+entry.getValue().password);
	         }
	       System.out.println("1-�����ϼ��˵�\n2-�������˵�\n3-ע����¼");
	            String choose2=in.nextLine();
	               switch(choose2)
	                     {
	                         case "1":Admin.seeAdmin(u);break;
	                         case "2":UserUi.AdminManagebar(u);break;
	                         case "3":new UserUi();break;
	                         default:
	                        	 System.out.println("��Ч����,�Զ������ϼ��˵�!");
	                        
	                        	 Admin.seeAdmin(u);
	                        	 
	                     }
		
	}
	public static void seeOneAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		HashMap<String,User> map=User.ReadUserFromFile();
		System.out.println("�������ѯ����(������ʽ��admin+�����ַ���teach+�����ַ�):");
        Scanner  in=new Scanner(System.in);
        String loginid=in.nextLine();
        while(!(loginid.substring(0, 5).equals("admin")||loginid.substring(0, 5).equals("teach")))
			{
		         System.out.println("������ʽ�������,���������룡");
		         loginid=in.nextLine();
		         if(loginid.length()<5)
		 			loginid="      ";
			}
      for(Map.Entry<String, User>entry:map.entrySet())
       {
	        if(entry.getKey().equals(loginid))
	         {
	        	System.out.println("����              "+"����           "+"�Ա�        "+"����             "+"��������            "+"�˻�����        ");
		        System.out.println(entry.getKey()+"     "+entry.getValue().name+"    "+entry.getValue().sex+"    "+entry.getValue().age+"    "+entry.getValue().department+"     "+entry.getValue().password);
	         }
	        
        }
      System.out.println("�Ƿ������ѯ����Ա��y/n\n����y�������ѯ,n�򷵻��ϼ��˵�!");
		String choose=in.nextLine();
		while(!(choose.equals("y")||choose.equals("n")))
		{
		   
			 
				  System.out.println("������������������!");
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
		System.out.println("������鿴ѡ��: \n 1-�鿴���й���Ա \n 2-��ѯָ������Ա\n 3-�����ϼ��˵�\n 4-�������˵�");
		
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
              	 System.out.println("��Ч����,������ѡ��!");
              
              	 Admin.seeAdmin(u);
		    	   
		 }
	}
	
	public void deleteAdmin(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("��������Ҫɾ��ָ������:");
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
				System.out.println("����"+loginid+"����Աɾ���ɹ�");
				
			}
		}
		System.out.println("�Ƿ����ɾ������Ա��y/n\n����y�������ѯ,n�򷵻��ϼ��˵�!");
		String choose=in.nextLine();
		while(!(choose.equals("y")||choose.equals("n")))
		{
		   
			 
				  System.out.println("������������������!");
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
	public void changeAdmin(User u) {//��
		// TODO Auto-generated method stub
		
	}
	public void changeAdminPassword(User u) {//��
		// TODO Auto-generated method stub
		
	}
		

}