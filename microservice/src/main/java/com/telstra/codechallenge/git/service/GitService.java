package com.telstra.codechallenge.git.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telstra.codechallenge.git.domain.response.GetHottestRepositoryResponseDTO;
import com.telstra.codechallenge.git.domain.response.GetOldestRepositoryResponseDTO;

/**
 * @author Kabir Imam
 *
 */
@Service
public interface GitService {
	
	/**
	 * Find the hottest repositories created in the last week
	 * @param count
	 * @return GetHottestRepositoryResponseDTO
	 */
	ResponseEntity<GetHottestRepositoryResponseDTO> getHottestRepositories(Integer count);
	
	
	/**
	 * Find the oldest user accounts with zero followers
	 * @param count
	 * @return GetOldestRepositoryResponseDTO
	 */
	ResponseEntity<GetOldestRepositoryResponseDTO>  getOldestRepositories(Integer count);
	
}
