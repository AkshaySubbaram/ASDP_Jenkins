package com.bank.lad.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bank.lad.dao.LadDao;
import com.bank.lad.model.LadModel;
import com.bank.lad.service.LadService;

@ExtendWith(MockitoExtension.class)
public class LadServiceTest {
	
	@Mock
	private LadDao ladDao;
	
	@InjectMocks
	private LadService ladService;
	
	private LadModel ladModel;
	
	@Test
	public void getAllDataTest(){
		LadModel lam = new LadModel(1l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello");
		LadModel lam1 = new LadModel(2l,"Akshay","Sharma","akshay@gmail.com",9538006002l,123456l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello");
		
		List<LadModel> ls = new ArrayList<>();
		ls.add(lam);
		ls.add(lam1);
		
		doReturn(ls).when(ladDao).findAll();
		List<LadModel> lm = ladService.getAllData();
		assertThat(lm.size()).isEqualTo(2);
        assertEquals(lm.get(0), ls.get(0));
        assertEquals(lm.get(1), ls.get(1));
	}
	
	@Test
	public void getAllDataByIdTest(){
		LadModel lam = new LadModel(1l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello");
		
		Mockito.when(ladDao.findById(Mockito.any())).thenReturn(Optional.of(lam));
		Optional<LadModel> lam1 = ladService.getById(1l);
		
		assertEquals(lam.getAddress(), lam1.get().getAddress());
	}
	
	@Test
	public void getUpdateTest(){
		LadModel lam = new LadModel(1l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
				80002288655l,"BXJPA5215N","SDFG","hello");
		
		LadModel lamUpdate = new LadModel(1l,"Shekar","Arvind","Sunil@gmail.com",130000l,8337345l,"Hyd",
				1234567890l,"BXJPA5215N","SDFG","hello");
		
		Mockito.when(ladDao.findById(Mockito.any())).thenReturn(Optional.of(lamUpdate));
		Optional<LadModel> lam1 = ladService.getById(1l);
		
		assertEquals(lamUpdate.getAddress(),lam1.get().getAddress());
		assertNotEquals(lam.getAddress(), lam1.get().getAddress());
	}
	
	
}
