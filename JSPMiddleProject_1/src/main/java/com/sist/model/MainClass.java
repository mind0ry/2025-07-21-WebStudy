package com.sist.model;
import java.text.SimpleDateFormat;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		 String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		 StringTokenizer st=new StringTokenizer(today,"-");
		 String strYear="2025";
		 String strMonth="10";
		 String strDay=null;
		 
		 if(strYear==null) {
			  strYear=st.nextToken();
		  }
		  if(strMonth==null) {
			  strMonth=st.nextToken();
		  }
		  strDay=st.nextToken();
		  System.out.println(strYear+strMonth+strDay);
		  
		  
	}
}
