//package en.edu.lingnan.test;
//
//import java.util.Scanner;

//import en.edu.lingnan.Dao.AdminiDao;
//import en.edu.lingnan.Dao.BooksDao;
//import en.edu.lingnan.Dao.BorrowBookDao;
//import en.edu.lingnan.Dao.StudentDao;
//import en.edu.lingnan.Dto.BooksDto;
//import en.edu.lingnan.Dto.ClassDto;

//public class JdbcTest1 {
//	public static void main(String[] args) {
//		int i,k;
//		BooksDao b =new BooksDao();
//		StudentDao s= new StudentDao();
//		boolean fg = false;
//		BorrowBookDao bb =new BorrowBookDao();
//		AdminiDao a = new AdminiDao();
//		Scanner input = new Scanner(System.in);
//		while(true)
//		{
//			System.out.println("              1.注册              ");       
//			System.out.println("              2.登录             ");
//			System.out.println("===========请输入1或2 ");
//			int l = input.nextInt();
//			if(l==1)
//			{
//				a.addAdminiInfo();
//				System.out.println("注册成功！现进入管理员界面..."); break;
//			}
//			else {
//			//if(a.LoginAdminiInfo("1","2"))
//			{
//				break;
//			}
//			else{
//	    		System.out.println("密码错误，请重新输入！");
//	    	}
//			}
//		}
//		while(true)
//		{ 
//			System.out.println("*********欢迎来岭师图书馆管理系统********");
//			System.out.println("              1.图书信息              ");       
//			System.out.println("              2.读者信息              ");        
//			System.out.println("              3.管理员信息            ");       
//			System.out.println("              4.借阅信息              ");           
//			System.out.println("              5.还书信息              ");           
//			System.out.println("              6.逾期罚款或损坏赔偿信息");        
//			System.out.println("              0.退出                  ");            
//			System.out.println("              请输入选择功能的序号   :");	
//			do{
//			System.out.println("请输入0——6"); 
//	    	System.out.println("**************************************************"); 
//	    	i = input.nextInt();
//			}while(i<0||i>6);
//	    	switch(i)
//	    	{
//	    	//退出
//	    	case 0:System.out.println("你已经退出系统！"); return;  
//	    	//图书信息
//    		case 1:   
//    			System.out.println("*************图书信息:      ");        
//    	    	System.out.println("   1. 查询图书信息:      ");       
//    	    	System.out.println("   2. 插入图书信息:      ");       
//    	    	System.out.println("   3. 删除图书信息:      ");       
//    	    	System.out.println("   4. 修改图书信息:      ");         
//    	    	int a1=input.nextInt();               
//    	    	switch(a1)          
//    	    	{                  
//    	    	case 1:            
//    	    		System.out.println("*************欢迎进入图书信息查询系统:      "); 
//    	    		System.out.println("   1. 无条件查询图书信息:      ");    
//    	    		System.out.println("   2. 按id查询图书信息:      "); 
//    	    		int b1=input.nextInt();	
//    	    		switch(b1)          
//        	    	{                  
//        	    	case 1:
//        	    		b.findallBooksInfo();break;
//        	    	case 2:
//        	    		b.findBooksid();break;
//    	    		}break;
//    	    	case 2:
//    	    		System.out.println("*************欢迎进入图书信息插入系统:      "); 
//    	    		b.addBooksInfo();break;
//    	    	case 3:
//    	    		System.out.println("*************欢迎进入图书信息删除系统:      "); 
//    	    		b.deleteBooksid();break;
//    	    	case 4:
//    	    		System.out.println("*************欢迎进入图书信息查询修改系统:      "); 
//    	    		b.UpdateBooksInfo(); break;
//    	    	}break;
//    	    	//读者信息
//    		case 2:
//    			System.out.println("*************读者信息:      ");        
//    	    	System.out.println("   1. 查询读者信息:      ");       
//    	    	System.out.println("   2. 插入读者信息:      ");       
//    	    	System.out.println("   3. 删除读者信息:      ");       
//    	    	System.out.println("   4. 修改读者信息:      ");         
//    	    	int p=input.nextInt();               
//    	    	switch(p)          
//    	    	{                  
//    	    	case 1:            
//    	    		System.out.println("*************欢迎进入读者信息查询系统:      "); 
//    	    		System.out.println("   1. 无条件查询读者信息:      ");    
//    	    		System.out.println("   2. 按id查询读者信息:      "); 
//    	    		int b1=input.nextInt();	
//    	    		switch(b1)          
//        	    	{                  
//        	    	case 1:
//        	    		s.findallStudentInfo();break;
//        	    	case 2:
//        	    		b.findBooksid();break;
//    	    		}break;
//    	    	case 2:
//    	    		System.out.println("*************欢迎进入读者信息插入系统:      "); 
//    	    		s.addStudentInfo();break;
//    	    	case 3:
//    	    		System.out.println("*************欢迎进入读者信息删除系统:      "); 
//    	    		s.deleteStudentid();break;
//    	    	case 4:
//    	    		System.out.println("*************欢迎进入读者信息查询修改系统:      "); 
//    	    		s.UndateStudentInfo(); break;
//    	    	}
//    			break;
//    	    	//管理员信息
//    		case 3: 
//    			System.out.println("*************欢迎进入管理员查询系统:      ");  
//    			a.findallAdminiInfo();break;
//    			//借阅图书信息
//    		case 4:  
//    			System.out.println("       借阅图书信息:      ");        
//    	    	System.out.println("   1. 查询借阅图书信息:      ");       
//    	    	System.out.println("   2. 插入借阅图书信息:      ");       
//    	    	System.out.println("   3. 删除借阅图书信息:      ");       
//    	    	System.out.println("   4. 修改借阅图书信息:      ");         
//    	    	int t1=input.nextInt();               
//    	    	switch(t1)          
//    	    	{                  
//    	    	case 1:            
//    	    		System.out.println("*************欢迎进入借阅图书信息查询系统:      "); 
//    	    		System.out.println("   1. 无条件查询借阅图书信息:      ");    
//    	    		System.out.println("   2. 按id查询借阅图书信息:      "); 
//    	    		int b1=input.nextInt();	
//    	    		switch(b1)          
//        	    	{                  
//        	    	case 1:
//        	    	    bb.findallBorrowBookInfo(); break;
//        	    	case 2:
//        	    		bb.findaBorrowBookid();break;
//    	    		}break;
//    	    	case 2:
//    	    		System.out.println("*************欢迎进入插入借阅图书信息查询系统:      "); 
//    	    		bb.addBorrowBooksInfo();break;
//    	    	case 3:
//    	    		System.out.println("*************欢迎进入删除借阅图书信息查询系统:      "); 
//    	    		bb.deleteBorrowBooksid();break;
//    	    	case 4:
//    	    		System.out.println("*************欢迎进入修改借阅图书信息查询系统:      "); 
//    	    		bb.UndateorrowBooksInfo();break;
//    	    	}
//		
//	    	}
//	    	} 	
//		
//	}
//
//}