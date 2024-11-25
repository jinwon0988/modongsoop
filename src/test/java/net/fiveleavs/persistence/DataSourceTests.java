package net.fiveleavs.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@WebAppConfiguration
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try (Connection conn= dataSource.getConnection()){
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}