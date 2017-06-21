package com.choa.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileSaver {
	
	public String filesave(String realPath,String oriName, byte [] fileData) throws Exception{
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		//upload 저장 되는 실제 파일 name
		String fileName=UUID.randomUUID().toString()+"_"+oriName;
		File taget = new File(f, fileName);
		FileCopyUtils.copy(fileData, taget);
		
		return fileName;
	}

}
