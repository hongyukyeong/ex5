package com.choa.ex5;

import java.io.File;
import java.util.UUID;

import javax.activation.FileDataSource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.util.FileSaver;

@Controller
public class FileUploadController {
	
	@RequestMapping("/test/fileUpForm")
	public void fileUp(){
		
	}
	
	
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload1(String name, MultipartHttpServletRequest request) throws Exception{
		System.out.println("NAME : "+name);		
		MultipartFile f = request.getFile("f1");
		System.out.println("getname:" + f.getName());
		System.out.println("originalname:" + f.getOriginalFilename());
		System.out.println("size:" + f.getSize());
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		FileSaver fs = new FileSaver();
		fs.filesave(path, f.getOriginalFilename(), f.getBytes());
	}
	
	
	
	
	
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload2(String name, MultipartFile f1, HttpSession session)throws Exception{
		System.out.println("getname:" + f1.getName());
		System.out.println("originalname:" + f1.getOriginalFilename());
		System.out.println("size:" + f1.getSize());
		String path = session.getServletContext().getRealPath("resources/upload");
		FileSaver fs = new FileSaver();
		fs.filesave(path, f1.getOriginalFilename(), f1.getBytes());
		
	}
	
	@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload3(FileDTO fileDTO, HttpSession session)throws Exception{
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/upload");
		String oriName = fileDTO.getF1().getOriginalFilename();
		byte [] fileDate = fileDTO.getF1().getBytes();
		
		fs.filesave(realPath, oriName, fileDate);
	}
	
	
}
