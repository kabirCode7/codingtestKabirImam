package com.telstra.codechallenge.git.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.git.domain.response.GetHottestRepositoryResponseDTO;
import com.telstra.codechallenge.git.domain.response.GetOldestRepositoryResponseDTO;
import com.telstra.codechallenge.git.service.GitService;

@RestController
@RequestMapping("v1/git")
public class GitController {
	
	
	@Autowired
	private GitService gitService;
	
	/**
	 * @param count
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/hottest")
	public ResponseEntity<GetHottestRepositoryResponseDTO> getHottestReposotories(
			@RequestParam(value = "count", required = true) Integer count){
		
		return gitService.getHottestRepositories(count);
	}
	
	
	
	/**
	 * @param count
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/oldest")
	public ResponseEntity<GetOldestRepositoryResponseDTO> getOldestReposotories(
			@RequestParam(value = "count", required = true) Integer count){
		
		return gitService.getOldestRepositories(count);
	}
	
}
