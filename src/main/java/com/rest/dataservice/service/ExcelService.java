/**
 * 
 */
package com.rest.dataservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.UserInfoMapper;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Kamal
 *
 */
public interface ExcelService {
	
	UserInfo store(MultipartFile file);
	
}
