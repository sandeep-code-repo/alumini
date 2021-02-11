
package com.rest.dataservice.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.entity.UserInfo;
import com.rest.dataservice.helper.UserInfoMapper;
import com.rest.dataservice.repository.UserRepository;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ExcelUtil;
import com.rest.dataservice.util.ResponseObject;

/**
 * @author Kamal
 *
 */
@Service
public class ExcelServiceImpl  implements ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelServiceImpl.class);
	  
	  @Autowired
	  UserRepository userRepository;

	  public UserInfo store(MultipartFile file) {
	    try {
	      List<UserInfo> info = ExcelUtil.parseExcelFile(file.getInputStream());
	      return info.get(0);
	    } catch (IOException e) {
	    	
	    	
	    	
			logger.error("Error inside method  store Info :: "+e.getMessage());
	 
	    	 throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }


}
