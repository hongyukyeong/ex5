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
import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	
	@RequestMapping("memberJoin")
	public void memberJoin(){}

	@RequestMapping("memberLogin")
	public void memberLogin(){}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		
		return "redirect:/"; //처음으로 되돌아가라
	}

	
	
	@RequestMapping(value="/studentJoin",method=RequestMethod.POST)
	public String memberJoin(StudentDTO studentDTO, Model model, HttpSession session) throws Exception{
		System.out.println("Student");
		
		int result = studentServiceImpl.memberJoin(studentDTO, session);
		
		String message ="가입 실패";
		
		if(result>0){
			message="가입 성공";
		}

		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		
		
		return "commons/result";
	}
	
	
	
	@RequestMapping(value="/studentLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO=studentServiceImpl.memberLogin(memberDTO);
		
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
	
	
	@RequestMapping(value="/memberPage")
	public void memberPage(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		MemberDTO memberDTO2 = studentServiceImpl.memberPage(memberDTO);
		model.addAttribute("student", memberDTO2);
		
		
	}

}
