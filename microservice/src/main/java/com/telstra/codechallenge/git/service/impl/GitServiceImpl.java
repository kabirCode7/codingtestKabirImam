package com.telstra.codechallenge.git.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telstra.codechallenge.git.constants.Constants;
import com.telstra.codechallenge.git.domain.response.GetHottestRepositoryResponseDTO;
import com.telstra.codechallenge.git.domain.response.GetOldestRepositoryResponseDTO;
import com.telstra.codechallenge.git.external.response.GetHottestRepositoryExternalResponseDTO;
import com.telstra.codechallenge.git.external.response.GetOldestRepositoryExternalResponseDTO;
import com.telstra.codechallenge.git.external.response.HottestItems;
import com.telstra.codechallenge.git.external.response.OldestItems;
import com.telstra.codechallenge.git.service.GitService;
import com.telstra.codechallenge.git.utility.GitApiUtility;

/**
 * @author Kabir Imam
 *
 */
@Service
public class GitServiceImpl implements GitService{

	private static final String DATE_FORMAT = "YYYY-MM-dd";
	private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);


	@Autowired
	private GitApiUtility gitApiUtility;




	/**
	 * Find the hottest repositories created in the last week
	 * @param count
	 * @return GetHottestRepositoryResponseDTO
	 */

	@Override
	public ResponseEntity<GetHottestRepositoryResponseDTO> getHottestRepositories(Integer count) {
		GetHottestRepositoryResponseDTO response = null;

		List<HottestItems> demandedHottestRepoList = new ArrayList<HottestItems>();

		try{
			Date currentDate = new Date();
			LocalDateTime localDateTimeBeforeOneWeek = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().minusDays(7);
			Date localDateTimeBeforeOneWeekOnDate = Date.from(localDateTimeBeforeOneWeek.atZone(ZoneId.systemDefault()).toInstant());
			String dateString=dateFormat.format(localDateTimeBeforeOneWeekOnDate);

			String requestDateString="created:>"+dateString;

			GetHottestRepositoryExternalResponseDTO gitResponse=gitApiUtility.getHottestRepositoriesFromGit(requestDateString, Constants.STAR_SORT, Constants.DESENDING);
			if(null!= gitResponse && null!= gitResponse.getItems()){
				demandedHottestRepoList=gitResponse.getItems().stream().limit(count).collect(Collectors.toList());

				response= GetHottestRepositoryResponseDTO.builder().hottestRepositoryList(demandedHottestRepoList).build();
			}

			return new ResponseEntity<GetHottestRepositoryResponseDTO>(response,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<GetHottestRepositoryResponseDTO>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Find the oldest user accounts with zero followers
	 * @param count
	 * @return GetOldestRepositoryResponseDTO
	 */

	@Override
	public ResponseEntity<GetOldestRepositoryResponseDTO> getOldestRepositories(Integer count) {
		GetOldestRepositoryResponseDTO response = null;
		List<OldestItems> demandedOldestItemList= new ArrayList<OldestItems>();
		try{
			
			GetOldestRepositoryExternalResponseDTO gitResponse= gitApiUtility.getOldestRepositoriesFromGit(Constants.FOLLOWERS_COUNT, Constants.JOINED_SORT, Constants.ASSENDING);
			if(null!= gitResponse && null!= gitResponse.getItems()){
				demandedOldestItemList = gitResponse.getItems().stream().limit(count).collect(Collectors.toList());
				response= GetOldestRepositoryResponseDTO.builder().oldestItemList(demandedOldestItemList).build();
			}
			return new ResponseEntity<GetOldestRepositoryResponseDTO>(response,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<GetOldestRepositoryResponseDTO>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}

}
