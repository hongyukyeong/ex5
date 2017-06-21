package com.choa.member.teacher;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.MyabstractTestUnit;

public class TeacherDAOImplTest extends MyabstractTestUnit {

	@Autowired
	private TeacherDAOImpl dao;
	private static TeacherDTO teacherDTO;
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	
	@Test
	public void test() throws Exception {
		int result = dao.memberJoin(teacherDTO);
		assertEquals(1, result);
		
	}
	
	@BeforeClass
	public static void mekeTeacher() throws Exception{
		
		String data = "choachoa5";
		
		teacherDTO = new TeacherDTO();
		
		teacherDTO.setId(data);
		teacherDTO.setPw(data);
		teacherDTO.setName(data);
		teacherDTO.setAge(22);
		teacherDTO.setGrade("t");
		teacherDTO.setFilename(data);
		teacherDTO.setOriname(data);
		teacherDTO.setTid(data);
		teacherDTO.setSubject(data);
		
		
	}

}
