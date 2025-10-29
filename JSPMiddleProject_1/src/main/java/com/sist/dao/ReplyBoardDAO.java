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
	
	public static void boardInsert(ReplyBoardVO vo) {
		SqlSession session=ssf.openSession(true);
		session.insert("boardInsert",vo);
		session.close();
	}
	/*
  <update id="boardHitIncrement" parameterType="int">
    UPDATE replyboard SET
    hit=hit+1
    WHERE no=#{no}
  </update>
  <select id="boardDetailData" resultType="ReplyBoardVO" parameterType="int">
    SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
    FROM replyboard
    WHERE no=#{no}
  </select>
	 */
	public static ReplyBoardVO boardDetailData(int no) {
		SqlSession session=ssf.openSession();
		session.update("boardHitIncrement",no);
		session.commit();
		ReplyBoardVO vo=session.selectOne("boardDetailData",no);
		session.close();
		return vo;
	}
	/*
  <select id="boardUpdateData" resultType="ReplyBoardVO" parameterType="int">
    SELECT no,name,subject,content
    FROM replyboard
    WHERE no=#{no}
  </select>
  <select id="boardGetPassword" resultType="string" parameterType="int">
    SELECT pwd FROM replyBoard
    WHERE no=#{no}
  </select>
  <update id="boardUpdate" parameterType="ReplyBoardVO">
    UPDATE replyboard SET
    name=#{name},subject=#{subject},content=#{content}
    WHERE no=#{no}
  </update>
	 */
	public static ReplyBoardVO boardUpdateData(int no) {
		SqlSession session=ssf.openSession();
		ReplyBoardVO vo=session.selectOne("boardUpdateData",no);
		session.close();
		return vo;
	}
	
}
