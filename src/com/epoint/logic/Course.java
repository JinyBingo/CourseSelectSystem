package com.epoint.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.epoint.man.User;
import com.epoint.ui.UserUi;

public class Course implements Serializable{
	public static final long serialVersionUID = 1l;
	public  String courseTeacherId;
	public  String coursetype;
	public String courseId;
	public String courseName;
	
	public String toString()
	{
		return courseId+"        "+courseName+"       "+courseTeacherId+"        "+coursetype;
	}
	public Course()
	{
		
	}
	public Course(String courseid2, String coursename2, String courseteacher, String coursetype) {
		this.courseId=courseid2;
		this.courseName=coursename2;
		this.courseTeacherId=courseteacher;
		this.coursetype=coursetype;
	}
	public static boolean WriteCourse(Course course) {
		boolean b=true;
		
     	HashMap<String,Course> map=ReadCourseFromFile();
     	if(map.size()==0)
     		map.put(course.courseId, course);
     	  //map.put("sysadmin",new User("sysadmin","bingo"));
     	
     	for(Map.Entry<String, Course>entry:map.entrySet())
     	{
     		  
     		if(course.courseId.equals(entry.getKey()))
     		    
     			{
     			b=false;
     			
     			}
     		else
     			map.put(course.courseId,course);break;
     			
     	}
     	//System.out.println(map.size());
     	WriteCourseToFile(map);  
		return b;
	}
	public static HashMap<String, Course> ReadCourseFromFile() {
		File f=new File("Course.txt");
    	if(!f.exists())
    		try {
    			f.createNewFile();
    		} catch (IOException e) {
    			
    			//不做处理
    		}
    	HashMap<String, Course> map=new HashMap<String,Course>();
    	
    			FileInputStream fin =null;
    			              //捕获文件读到文件尾异常及文件被删或被清空数据的情况，防止异常被抛出导致主线程结束
    				ObjectInputStream inp = null;
    				
						try {
							fin = new FileInputStream(f);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
					
    			
				
						//try {
							try {
								if(fin.available()==0)
									System.out.println("课程列表为空！");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
								try {
									inp=new ObjectInputStream(fin);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
						
					
					
							try {
								//if(!(inp.available()==0))
                           
								map=(HashMap<String, Course>) inp.readObject();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
 
					   
					
						try {
							inp.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
						
						
					
					//finally{
						//map.put("sysadmin",new User("sysadmin","bingo"));
 		//	}
					   return map;
					}
				

   	
		
	
	public static void WriteCourseToFile(HashMap<String, Course> map) {
		File f=new File("Course.txt");
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
	    
	    try {
	    	FileOutputStream fis=new FileOutputStream(f);
			ObjectOutputStream os=new ObjectOutputStream(fis);
			//map.put("sysadmin",new User("sysadmin","bingo"));
			os.writeObject(map);
			os.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
