package com.bank.lad.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.bank.lad.dao.LadDao;
import com.bank.lad.model.LadModel;

@DataJpaTest
public class LadDaoTest {
	
	@Autowired
	private LadDao ladDao;
	

    @Autowired
    private TestEntityManager entityManager;
       
    
//    @Test
//    public void addAllDataTest() {
//    	LadModel lam = new LadModel(1l,"Akshay","Sharma","akshay@gmail.com",123456l,9538006002l,"Bengaluru",
//				80002288655l,"BXJPA5215N","SDFG","hello");
//
//
//    	LadModel lam1 = ladDao.save(lam);
//        
//    	LadModel existUser = entityManager.find(LadModel.class, lam.getEmail());
//        assertThat(lam.getEmail()).isEqualTo(existUser.getEmail());
//
//    }
	

}


