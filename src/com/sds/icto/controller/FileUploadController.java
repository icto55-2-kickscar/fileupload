package com.sds.icto.controller;

import java.io.FileOutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	private static final Log LOG = LogFactory.getLog( FileUploadController.class );
	  
	@RequestMapping( "/form" )
	public String form() {
		return "form";
	}
	
	@RequestMapping( "/upload" )
	@ResponseBody
	public String upload( 
		@RequestParam Long deptNo, 
		@RequestParam("file") MultipartFile file ) {
        
		LOG.debug( " ######## deptNo : " + deptNo );

        String fileOriginalName = file.getOriginalFilename();
        String extName = fileOriginalName.substring( fileOriginalName.lastIndexOf(".") + 1, fileOriginalName.length() );
        String fileName = file.getName();
        Long size = file.getSize();
        
        // 저장파일 이름 만들기
        String saveFileName = "";
        Calendar calendar = Calendar.getInstance();
        saveFileName += calendar.get( Calendar.YEAR );
        saveFileName += calendar.get( Calendar.MONTH );
        saveFileName += calendar.get( Calendar.DATE );
        saveFileName += calendar.get( Calendar.HOUR );
        saveFileName += calendar.get( Calendar.MINUTE );
        saveFileName += calendar.get( Calendar.SECOND );
        saveFileName += calendar.get( Calendar.MILLISECOND );
        saveFileName += ( "." + extName );

        LOG.debug( " ######## fileOriginalName : " + fileOriginalName );
        LOG.debug( " ######## fileName : " + fileName );
        LOG.debug( " ######## fileSize : " + size );
        LOG.debug( " ######## fileExtensionName : " + extName );
        LOG.debug( " ######## saveFileName : " + saveFileName );        

        writeFile( file, "C:\\uploads", saveFileName );
        
		return "upload complete<br><a href='/fileupload/form'> back to upload form </a>";
	}
	
	private void writeFile( MultipartFile file, String path, String fileName ) {
		FileOutputStream fos = null;
		try {
			byte fileData[] = file.getBytes();
			fos = new FileOutputStream( path + "\\" + fileName );
			fos.write(fileData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		}
	}	
}
