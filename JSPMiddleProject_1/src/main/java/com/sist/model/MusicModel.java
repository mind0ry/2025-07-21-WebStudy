package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MusicDAO;
import com.sist.vo.MusicVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MusicModel {
	@RequestMapping("music/list.do")
	public String music_list(HttpServletRequest request,HttpServletResponse response) {
		String page=request.getParameter("page");
		  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  Map map=new HashMap();
		  int rowSize=12;
		  int start=(rowSize*curpage)-(rowSize-1);
		  int end=rowSize*curpage;
		  map.put("start", start);
		  map.put("end", end);
		  List<MusicVO> list=MusicDAO.musicListData(map);
		  int totalpage=MusicDAO.musicTotalPage();
		  
		  // 블록별 처리
		  final int BLOCK=10;
		  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  
		  if(endPage>totalpage) {
			  endPage=totalpage;
		  }
		  request.setAttribute("list", list);
		  request.setAttribute("curpage", curpage);
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("startPage", startPage);
		  request.setAttribute("endPage", endPage);
		  // include => 설정 파일
		  request.setAttribute("main_jsp", "../music/list.jsp");
		  return "../main/main.jsp";
	  }
	@RequestMapping("music/detail.do")
	public String music_detail(HttpServletRequest request,HttpServletResponse response) {
		// 사용자가 보낸 데이터 받기  ?fno &page
		String no=request.getParameter("no");
		String curpage=request.getParameter("page");
		// 상세보기 데이터
		MusicVO vo=MusicDAO.musicDetailData(Integer.parseInt(no));
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../music/detail.jsp");
		return "../main/main.jsp";
	}
	}

