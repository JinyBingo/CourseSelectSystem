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
			 System.out.println("�������û���:");
			 Scanner in=new Scanner(System.in);
			 String loginid=in.nextLine();
			 while(loginid.length()<5)
			 {
				 
					 System.out.println("��¼ID������󣬱������5λ,��������ID");
					 loginid=in.nextLine();
			 }
			 System.out.println("����������:");
			 String password=in.nextLine();
			 User user=new User(loginid,password);
			 
			 if(user.login())
			 {
				 loginError=0;
				 System.out.println("��¼�ɹ���");
				 if(user.checkUsertype()==1||user.checkUsertype()==2)
					 AdminManagebar(user);
				 else
					 studentMunuBar(user);
					 
			 }
			 else
				 System.out.println("�����û��������벻��ȷ����¼ʧ��");
			   loginError++;
			   if(loginError>2)
			   {
				   System.out.println("������¼ʧ��3�Σ�ϵͳ���Զ���\n  �ټ���");
				   System.exit(0);
			   }
		 }
	 }
			 
		 
	 

	public static void studentMunuBar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		      System.out.println(u.loginId+"ͬѧ����ã����������ѡ��\n1-ѡ��γ�\n2-��ѯ��ѡ\n3-�鿴��ѡ\n4-�޸�ѡ��\n5-�޸�����\n6-ע����¼");
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
		    	  System.out.println("��Ч���룬������ѡ��");
		    	  studentMunuBar(u);
		      }
	}

	

	public static void AdminManagebar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		if(u.checkUsertype()==1)
		{
			System.out.println(u.loginId+"ϵͳ����Ա�����!������������ͣ�\n1-�γ̹���\n2-ѧ������\n3-��ͨ����Ա����\n4-ע����¼");
		
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":AdminCourseManagebar(u);break;
		case "2":adminStudentManagebar(u);break;
		case "3":teaAndAdminManagebar(u);break;
		case "4":System.out.println("ע����¼�ɹ����ټ���");
				new UserUi();break;
				default:
					System.out.println("��������������ѡ��");
					AdminManagebar(u);
		}
		}
		else if(u.checkUsertype()==2)
		{
			System.out.println(u.loginId+"����Ա����ã���������ķ������ͣ�\n1-�γ̹���\n2-ѧ������\n3-ע����¼");
			Scanner in=new Scanner(System.in);
			String choose=in.nextLine();
			switch(choose)
			{
			case "1":AdminCourseManagebar(u);break;
			case "2":adminStudentManagebar(u);break;
			case "3":System.out.println("ע����½�ɹ����ټ���");
			new UserUi();break;
			default:
				System.out.println("��������������ѡ��");
				AdminManagebar(u);
			}
		}
		else if(u.checkUsertype()==3)
		{
			System.out.println(u.loginId+"��ʦ����ã���������������ͣ�\n1-��ѧ����\n2-ѧ������\n3-ע����¼");
		  	Scanner in=new Scanner(System.in);
		  	String choose=in.nextLine();
		  	switch(choose)
		  	{
		  	case "1":teacherCourseManage(u);break;
		  	case "2":teacheStudentmanage(u);break;
		  	case "3":
		  		System.out.println("ע����¼�ɹ����ټ���");
		  		new UserUi();
		  		default:
		  			System.out.println("��������������ѡ��");
		  			AdminManagebar(u);
		  	}
		}
		
	}

	public static void teaAndAdminManagebar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("������������ͣ�\n1-������ͨ����Ա\n2-�鿴��ͨ����Ա\n3-ɾ����ͨ����Ա\n4-�޸���ͨ����Ա\n5-�����ϼ��˵�\6-ע����¼");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":new Admin().addAdmin(u);addStudentbar(u);break;
		case "2":Admin.seeAdmin(u);break;
		case "3":new Admin().deleteAdmin(u);break;
		case "4":new Admin().changeAdmin(u);break;
		case "5":AdminManagebar(u);break;
		case "6":System.out.println("ע����¼�ɹ����ټ���");
		new UserUi();break;
		default:
			System.out.println("��������������ѡ��");
			teaAndAdminManagebar(u);
			
		}
	}

	public static void adminStudentManagebar(User u) {
		System.out.println("������������ͣ�\n1-����ѧ��\n2-�鿴ѧ��\n3-ɾ��ѧ��\n4-�޸�ѧ��\n5-�����ϼ��˵�\6-ע����¼");
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
		case "6":System.out.println("ע����¼�ɹ����ټ���");
			try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
		default:
			System.out.println("��������������ѡ��");
			
				adminStudentManagebar(u);
			
			
		}
		
	}
public static void addStudentbar(User u)
{
	Scanner in=new Scanner(System.in);
	try {
		if(new Admin().addStudent())
			System.out.println("���ѧ����ɣ��Ƿ������\ny-����\nf-�����ϼ��˵�\nx-ע����¼");
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
		   System.out.println("���������Զ������ϼ��˵���");
		   adminStudentManagebar(u);
	   }
}

	public static void manageAdminbar(User u) {
		// TODO Auto-generated method stub
		
	}

	

	public static void teacheStudentmanage(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("��������������ͣ�\n1-�鿴ѡ����ε�ѧ��\2-�鿴�������ڵĿγ�\n3-�����ϼ��˵�\n4-ע����¼");
		Scanner in=new Scanner(System.in);
		String choose=in.nextLine();
		switch(choose)
		{
		case "1":teacherSeeStudent(u);break;
		case "2":teacherSeeCourse(u);break;
		case "3":AdminManagebar(u);break;
		case "4":
			System.out.println("ע����¼�ɹ����ټ���");
			new UserUi();
		default:
			System.out.println("��������������ѡ��");
			teacheStudentmanage(u);
		}
		
	}

	public static void teacherSeeCourse(User u) {
		// TODO Auto-generated method stub
		
	}

	public static void teacherSeeStudent(User u) {
		System.out.println("��ѡ��鿴���ͣ�\1n-�鿴����ѧ��\n2-�鿴ָ��ѧ��");
		
		
	}

	public static void teacherCourseManage(User u) {
		System.out.println("��ѡ��鿴����:\n1-�鿴��������ڿ�\n2-�����ϼ��˵�\n3-�������˵�\n4-ע����¼");
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
			System.out.println("ע����¼�ɹ����ټ���");
			try {
				new UserUi();
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}break;
			default:
				System.out.println("��������������ѡ��");
				teacherCourseManage(u);
		}
		
	}

	
	public  static void AdminCourseManagebar(User u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("������������ͣ�\n1-�γ�����\n2-�γ̲鿴\n3-�γ�ɾ��\n4-�γ��޸�\n5-�����ϼ��˵�\n6-ע����¼");
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
		case "6":System.out.println("ע����¼�ɹ����ټ���");
		new UserUi();break;
		default:
			System.out.println("��������������ѡ��");
			AdminCourseManagebar(u);
			
		}
		
		
	}
 public static void addCoursebar(User u)
 {
	 Scanner in=new Scanner(System.in);
	 if(Admin.addCourse(u))
	      System.out.println("��ӿγ̳ɹ����Ƿ������ y-����  n-�����ϼ��˵� x-ע����¼");
               String choose=in.nextLine();
               switch(choose)
               {
               case "y":Admin.addCourse(u);addCoursebar(u);break;
               case "n":try {
					AdminCourseManagebar(u);
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}break;
               case "x":System.out.println("ע����¼�ɹ����ټ���");
				try {
					new UserUi();
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
               break;
               default:
               	System.out.println("���������Զ������ϼ��˵���");
               	try {
					AdminCourseManagebar(u);
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
               }
 }
	

	
	
}
