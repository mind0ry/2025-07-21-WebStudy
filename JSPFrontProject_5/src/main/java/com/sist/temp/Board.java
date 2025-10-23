package com.sist.temp;
import com.sist.controller.*;
import com.sist.controller.RequestMapping;
public class Board {
   @RequestMapping("insert.do")
   public void insert() {
	   System.out.println("Board:insert() Call...");
   }
   @RequestMapping("delete.do")
   public void delete() {
	   System.out.println("Board:delete() Call...");
   }
   @RequestMapping("update.do")
   public void update() {
	   System.out.println("Board:update() Call...");
   }
   @RequestMapping("select.do")
   public void select() {
	   System.out.println("Board:select() Call...");
   }
   @RequestMapping("find.do")
   public void find() {
	   System.out.println("Board:find() Call...");
   }
}
