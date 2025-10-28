package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;
public class ReplyBoardDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	/*
	 * <select id="boardListData" resultType="ReplyBoardVO" parameterType="int">
  <!-- 
  		group_tab : 간격조절
  			AAAAA 0 
  			  => BBBBB 1
  			     => CCCCC 2
  		group_id : 답변을 모아둔 것
  		  	AAAAA 1 
  		  	  => BBBBB 1
  		  	     => CCCCC 1
  		  	  => DDDDD 1
  		  	EEEEE 2
  		  	  => KKKKK 2
  		group_step
  		    AAAAA 0
  		  	  => BBBBB 1
  		  	     => CCCCC 2
  		  	  => DDDDD 3
  		  	 
  		  	AAAAA			1	0
  		  	  => BBBBB		1	1
  		  	     => CCCCC	1	2
  		  	  => DDDDD      1   1
   -->
    SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab
    FROM replyboard
    ORDER BY group_id DESC,group_step ASC
    OFFSET #{start} ROWS NEXT 10 ROWS ONLY
  </select>
  <select id="boardTotalPage" resultType="int">
    SELECT CEIL(COUNT(*)/10.0)
    FROM replyboard
  </select>
	 */
	public static List<ReplyBoardVO> boardListData(int start) {
		SqlSession session=ssf.openSession();
		List<ReplyBoardVO> list=session.selectList("boardListData",start);
		session.close();
		return list;
	}
	
	public static int boardTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("boardTotalPage");
		session.close();
		return total;
	}
}
