package com.rest.dataservice;

  
  import org.junit.jupiter.api.Test; 
  import org.springframework.boot.test.context.SpringBootTest;
  
  import static org.assertj.core.api.Assertions.assertThat;
  import static org.junit.Assert.assertEquals;

  import java.util.ArrayList;
  import java.util.List;

  import org.json.JSONObject;
  import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;
  import org.junit.runner.RunWith;
  import org.mockito.Mockito;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
  import org.springframework.boot.test.mock.mockito.MockBean;
  import org.springframework.http.HttpStatus;
  import org.springframework.http.MediaType;
  import org.springframework.mock.web.MockHttpServletResponse;
  import org.springframework.test.context.junit4.SpringRunner;
  import org.springframework.test.web.servlet.MockMvc;
  import org.springframework.test.web.servlet.MvcResult;
  import org.springframework.test.web.servlet.RequestBuilder;
  import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
  import org.springframework.test.web.servlet.setup.MockMvcBuilders;
  import org.springframework.web.context.WebApplicationContext;

  import com.fasterxml.jackson.core.JsonProcessingException;
  import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.dataservice.constants.ApplicationConstants;
import com.rest.dataservice.controller.IndustryCategoryController;
import com.rest.dataservice.entity.IndustryCategory;
import com.rest.dataservice.service.IndustryCategoryService;
import com.rest.dataservice.util.CommonApiStatus;
import com.rest.dataservice.util.ResponseObject;

  
  @SpringBootTest 
  @RunWith(SpringRunner.class)
  public class IndustryApplicationTests {
  
	  
	  @Autowired
	  private WebApplicationContext webApplicationContext;
	  private MockMvc mockMvc;

	  @BeforeEach
	  public void setUp() {
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  }

	@MockBean
	private IndustryCategoryService industryCategoryService;
	
	private static final IndustryCategory mockIndustryCategory = new IndustryCategory();
	
	
  @Test
	public void testCreateIndustry() throws Exception {
	  
	  mockIndustryCategory.setId(1);
	  mockIndustryCategory.setName("Test Plant");
	  mockIndustryCategory.setAddress("Bhubaneswar");
	  mockIndustryCategory.setCategory("Power Plant");
	  mockIndustryCategory.setRegionalOfc("Bhubaneswar");
		
        String inputInJson = this.mapToJson(mockIndustryCategory);
		
		String URI = "/industry";
		
		ResponseObject mockIndustryResponse = new ResponseObject() ;
		CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		mockIndustryResponse.setData(mockIndustryCategory);
		mockIndustryResponse.setApiStatus(successApiStatus);
		
		Mockito.when(industryCategoryService.addIndustryDetails(Mockito.any(IndustryCategory.class))).thenReturn(mockIndustryResponse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		String expectedJson = this.mapToJson(mockIndustryResponse);
		
		assertThat(outputInJson).isEqualTo(expectedJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
  
  @Test
	public void testGetIndustryByCategory() throws Exception {
	  
	  
	  mockIndustryCategory.setId(1);
	  mockIndustryCategory.setName("Test Plant");
	  mockIndustryCategory.setAddress("Bhubaneswar");
	  mockIndustryCategory.setCategory("Power Plant");
	  mockIndustryCategory.setRegionalOfc("Bhubaneswar");
		
        String inputInJson = this.mapToJson(mockIndustryCategory);
		
		String URI = "/industry/Power Plant";
		
		ResponseObject mockIndustryResponse = new ResponseObject() ;
		CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		mockIndustryResponse.setData(mockIndustryCategory);
		mockIndustryResponse.setApiStatus(successApiStatus);
		
		Mockito.when(industryCategoryService.getIndustryDetailsByCategory(Mockito.anyString())).thenReturn(mockIndustryResponse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		String expectedJson = this.mapToJson(mockIndustryResponse);
		
		assertThat(outputInJson).isEqualTo(expectedJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	  
  }
  
  @Test
	public void testGetAllIndustry() throws Exception {
	  
	  IndustryCategory mockIndustryCategory1 = new IndustryCategory();
	  mockIndustryCategory1.setId(1);
	  mockIndustryCategory1.setName("Test Plant");
	  mockIndustryCategory1.setAddress("Bhubaneswar");
	  mockIndustryCategory1.setCategory("Power Plant");
	  mockIndustryCategory1.setRegionalOfc("Bhubaneswar");
	  
	  IndustryCategory mockIndustryCategory2 = new IndustryCategory();
	  mockIndustryCategory2.setId(2);
	  mockIndustryCategory2.setName("Test Plant2");
	  mockIndustryCategory2.setAddress("Bhubaneswar2");
	  mockIndustryCategory2.setCategory("Steel Plant");
	  mockIndustryCategory2.setRegionalOfc("Bhubaneswar2");
	  
	  List<IndustryCategory> industryList = new ArrayList<>();
	  industryList.add(mockIndustryCategory1);
	  industryList.add(mockIndustryCategory2);
		
      String inputInJson = this.mapToJson(mockIndustryCategory);
		
		String URI = "/industry";
		
		ResponseObject mockIndustryResponse = new ResponseObject() ;
		CommonApiStatus successApiStatus = new CommonApiStatus(ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS, HttpStatus.OK,
				ApplicationConstants.API_OVER_ALL_SUCCESS_STATUS);
		mockIndustryResponse.setData(industryList);
		mockIndustryResponse.setApiStatus(successApiStatus);
		
		Mockito.when(industryCategoryService.getIndustryList()).thenReturn(mockIndustryResponse);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		String expectedJson = this.mapToJson(mockIndustryResponse);
		
		assertThat(outputInJson).isEqualTo(expectedJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	  
}
  
  /**
	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
  
  
  
  }
 