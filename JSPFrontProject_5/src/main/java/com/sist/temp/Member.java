package com.sist.temp;
import com.sist.controller.*;
import com.sist.controller.RequestMapping;
public class Member {
	@RequestMapping("member_join.do")
	public void memberjoin() {
		System.out.println("Member:memberJoin() call...");
	}
	@RequestMapping("member_delete.do")
	public void memberDelete() {
		System.out.println("Member:memberDelete() call...");
	} 
	@RequestMapping("member_update.do")
	public void memberUpdate() {
		System.out.println("Member:memberUpdate() call...");
	}
}
