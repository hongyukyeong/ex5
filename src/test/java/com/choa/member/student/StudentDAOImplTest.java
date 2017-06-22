package com.choa.member.student;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.MyabstractTestUnit;
import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDAOImpl;
import com.choa.member.student.StudentDTO;

public class StudentDAOImplTest extends MyabstractTestUnit {
	
	@Autowired	
	private StudentDAOImpl dao;
	private static MemberDTO memberDTO;
	private static StudentDTO studentDTO;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Test
	public void test() throws Exception{
		
		StudentDTO memberDTO=(StudentDTO)dao.test(studentDTO);
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getPhone());
		
	}
	
	@BeforeClass //클래스가 시작하기 전에 해줘라
	public static void makeStudent() throws Exception {
		
		studentDTO= new StudentDTO();
		
		
		studentDTO.setId("student");
		studentDTO.setPw("student");
		studentDTO.setName("student");
		studentDTO.setAge(22);
		studentDTO.setGrade("student");
		studentDTO.setFilename("student");
		studentDTO.setOriname("student");
		studentDTO.setPhone("01012345678");
		studentDTO.setTid("teacher");
		
	

		
		
		
		}
	}
