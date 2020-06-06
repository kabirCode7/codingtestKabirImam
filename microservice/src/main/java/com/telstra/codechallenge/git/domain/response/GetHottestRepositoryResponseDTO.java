package com.telstra.codechallenge.git.domain.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.telstra.codechallenge.git.external.response.HottestItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Kabir Imam
 *
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown= true)
public class GetHottestRepositoryResponseDTO {
	
	private List<HottestItems> hottestRepositoryList;
	
}
