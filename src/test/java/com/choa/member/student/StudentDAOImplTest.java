package com.choa.member.student;

import static org.junit.Assert.*;

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
	private static StudentDTO studentDTO;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Test
	public void test() throws Exception{
		
		int result = studentServiceImpl.memberJoin(studentDTO);
		System.out.println(studentDTO);
		
		assertEquals(1, result);
		
	}
	
	@BeforeClass //클래스가 시작하기 전에 해줘라
	public static void makeStudent() throws Exception {
		
		studentDTO = new StudentDTO();
		
		
		studentDTO.setId("choachoa6");
		studentDTO.setPw("choachoa");
		studentDTO.setName("choachoa");
		studentDTO.setAge(22);
		studentDTO.setGrade("s");
		studentDTO.setFilename("choachoa");
		studentDTO.setOriname("choachoa");
		studentDTO.setSid("choachoa6");
		studentDTO.setPhone("choachoa");
		studentDTO.setTid("choachoa");

		
		
		
		}
	}
