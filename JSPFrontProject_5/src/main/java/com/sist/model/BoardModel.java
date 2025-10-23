package com.sist.model;

import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardModel {
	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("msg", "게시판목록");
		return "../board/list.jsp";
	}
	
	@RequestMapping("board/detail.do")
	public void board_detail(HttpServletRequest request,HttpServletResponse response) {
		JSONObject obj=new JSONObject();
		obj.put("id", "hong");
		obj.put("i", "hong");
		obj.put("ida", "hong");
		obj.put("iddd", "hong");
		try {
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(obj.toJSONString());
		} catch (Exception ex) {
		}
	}
}
