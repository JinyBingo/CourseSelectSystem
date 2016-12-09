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
import java.util.Map;

import com.epoint.logic.Course;

public class User implements Serializable{
	public static final long serialVersionUID = 1l;
	public String loginId;
    public String password;
	public String name;
	public String sex;
	public String age;
	public String department;
	public String usertype;
	public String major;
	public User()
	{
		
	}
	
	
    
	public User(String loginid, String password1) {
		this.loginId=loginid;
		this.password=password1;
		if(checkUsertype()==2)
			this.usertype="普通管理员";
		else if(checkUsertype()==3)
			
				this.usertype="教师";
		else if(checkUsertype()==1)
			this.usertype="系统管理员";
		else
			this.usertype="学生";
		
	}

	public int checkUsertype() {
		
		if(loginId.substring(0,5).equals("admin"))
			return 2;
		else if(loginId.substring(0, 5).equals("teach"))
			return 3;
		else if(loginId.equals("sysadmin"))
			return 1;
		else 
			return 4;
	}

	public boolean login() {
		boolean b=false;
		HashMap<String,User> map=ReadUserFromFile();
		
		for(Map.Entry<String, User>entry:map.entrySet())
		{
			if(entry.getValue().password.equals(password))
				b=true;
		}
		return b;
	}



	



	public static HashMap<String, User> ReadUserFromFile() {
		File f=new File("User.txt");
    	if(!f.exists())
    		try {
    			f.createNewFile();
    		} catch (IOException e) {
    			
    			//不做处理
    		}
    	HashMap<String, User> map=new HashMap<String,User>();
    	
    			FileInputStream fin;
    			try {               //捕获文件读到文件尾异常及文件被删或被清空数据的情况，防止异常被抛出导致主线程结束
    				ObjectInputStream inp;
    				fin = new FileInputStream(f);
    			
    				inp=new ObjectInputStream(fin);
    				
    			   map=(HashMap<String, User>) inp.readObject();
    			   
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
    				map.put("sysadmin",new User("sysadmin","bingo"));
    			}
    	
    		return map;
	}



	



	



	public static void WriteUserToFile(HashMap<String, User> map) {
		
		File f=new File("User.txt");
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
	    
	    try {
	    	FileOutputStream fis=new FileOutputStream(f);
			ObjectOutputStream os=new ObjectOutputStream(fis);
			map.put("sysadmin",new User("sysadmin","bingo"));
			os.writeObject(map);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
		
	}



	public boolean WriteUser(User u) {
		boolean b=true;
     	HashMap<String,User> map=ReadUserFromFile();
     	//map.put("sysadmin",new User("sysadmin","bingo"));
     	
     	for(Map.Entry<String, User>entry:map.entrySet())
     	{
     		  
     		if(u.loginId.equals(entry.getKey()))
     		    
     			{
     			b=false;
     			
     			}
     		else
     			map.put(u.loginId,u);break;
     			
     	}
     	//System.out.println(map.size());
     	WriteUserToFile(map);  
		return b;
	}



	

}
