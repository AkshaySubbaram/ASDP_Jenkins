package com.bank.lad.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.bank.lad.model.LadModel;
import com.bank.lad.service.LadService;

@SpringBootTest
@AutoConfigureMockMvc
public class LadControllerTest {
	
	@MockBean
	private LadService ladService;
	
	@InjectMocks
	private LadController ladController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	
	@Test
	public void getAllTest() throws Exception {
		LadModel lam = new LadModel(1l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello");
		LadModel lam1 = new LadModel(2l,"Akshay","Sharma","akshay@gmail.com",9538006002l,123456l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello");
		
		List<LadModel> ls = new ArrayList<>();
		ls.add(lam);
		ls.add(lam1);
		
		when(ladService.getAllData()).thenReturn(ls);
		mockMvc.perform(get("/bank")).andExpect(status().isOk())
        .andExpect(jsonPath("$.size()").value(2))
        .andDo(print());
	}
	
	@Test
	public void getIdTest() throws Exception {
		Optional<LadModel> lam = Optional.of(new LadModel(1l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello"));
		
		Mockito.when(ladService.getById(Mockito.any())).thenReturn(lam);	
		mockMvc.perform(get("/bank/1")).andExpect(status().isOk()).andDo(print());		
	}
	
	@Test
	public void getUpdateId() throws Exception {
		LadModel lam = new LadModel(4l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","fghjk","hello");
		
		LadModel updatedlam = new LadModel(6l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","fghjk","hello");

	       when(ladService.updateLoanData(lam.getId(),lam)).thenReturn(updatedlam);	        
	       mockMvc.perform(put("/bank/update/"+lam.getId()).contentType(MediaType.APPLICATION_JSON)
	       .content(objectMapper.writeValueAsString(lam))).andExpect(status().isOk()).andDo(print());
	}

}
