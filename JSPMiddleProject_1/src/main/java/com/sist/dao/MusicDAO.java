package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.CreateSqlSessionFactory;
import com.sist.commons.*;
import com.sist.vo.*;
public class MusicDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<MusicVO> musicListData(Map map) {
		SqlSession session=ssf.openSession();
		List<MusicVO> list=session.selectList("musicListData",map);
		session.close();
		return list;
	}
	public static int musicTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("musicTotalPage");
		session.close();
		return total;
	}
	public static MusicVO musicDetailData(int no) {
		SqlSession session=ssf.openSession();
		MusicVO vo=session.selectOne("musicDetailData",no);
		session.close();
		return vo;
	}
	public static List<MusicVO> musicTypeListData(Map map) {
		   List<MusicVO> list=null;
		   try {
			SqlSession session=ssf.openSession();
			list=session.selectList("musicTypeListData",map);
			session.close();
		   } catch (Exception ex) {
		     	ex.printStackTrace();
		   }
		   return list;
	   }
	   public static int musicTypeTotalPage(String cno) {
		   int total=0;
		   try {
			   SqlSession session=ssf.openSession();
			   total=session.selectOne("musicTypeTotalPage",cno);
			   session.close();
		   } catch (Exception ex) {
			  ex.printStackTrace();
		   }
		   return total;
	   }
	   public static List<MusicVO> musicFindListData(Map map)
	   {
		   List<MusicVO> list=null;
		   try
		   {
			   SqlSession session=ssf.openSession();
		       list=session.selectList("musicFindListData",map);
		       session.close();
		   }catch(Exception ex)
		   {
			  System.out.println("musicFindListData:"+ex.getMessage());
		   }
		   
		   return list;
	   }
	   public static int musicFindTotalPage(String cno) {
		   int total=0;
		   try {
			   SqlSession session=ssf.openSession();
			   total=session.selectOne("musicFindTotalPage",cno);
			   session.close();
		   } catch (Exception ex) {
			  ex.printStackTrace();
		   }
		   return total;
	   }
}
