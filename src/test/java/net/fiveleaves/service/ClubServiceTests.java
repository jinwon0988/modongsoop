package net.fiveleaves.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;
import net.fiveleaves.domain.ClubDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class ClubServiceTests {
	
	@Autowired
	private ClubService service;
	
	// 동호회 생성
	@Test
	public void testRegister() throws Exception {
		ClubDTO club = new ClubDTO();
		club.setClubName("새싹 동대문 동호회");
		club.setClubContent("새싹 동대문 동호회입니다.");
		club.setClubProfile(null);
		club.setAgeMin(null);
		club.setAgeMax(null);
		club.setCategoryNo(1L);
		club.setUserNo(1L);
		
		service.register(club);
		
		log.info("생성된 게시물의 번호 : " + club.getClubNo());
	}
	
	// 동호회 정보
	@Test
	public void testGet() throws Exception {
		Long clubNo = 1L;
		
		ClubDTO club = service.get(clubNo);
		
		log.info(club);
	}
}