package com.choa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.member.MemberDTO;
import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class TeacherController {
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	
	

	@RequestMapping(value="/teacherJoin",method=RequestMethod.POST)
	public String memberJoin(TeacherDTO teacherDTO, Model model, HttpSession session) throws Exception{
		System.out.println("Teacher");
		
		
		int result = teacherServiceImpl.memberJoin(teacherDTO, session);
		
		String message ="가입 실패";
		
		if(result>0){
			message="가입 성공";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		
		
		return "commons/result";
		
	}
	
	
	
	@RequestMapping(value="/teacherLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO=teacherServiceImpl.memberLogin(memberDTO);
		
		String message="LOGIN FAIL";
		
		if(memberDTO!=null){
			session.setAttribute("member", memberDTO);
			message="LOGIN SUCCESS";
		}
		String path="../";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("path", path);
		mv.addObject("message", message);
		mv.setViewName("commons/result");
		
		return mv;
	}
	
	
	
	
	
}
