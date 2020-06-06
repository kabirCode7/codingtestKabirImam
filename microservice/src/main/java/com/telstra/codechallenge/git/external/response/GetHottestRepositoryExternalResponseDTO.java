package com.telstra.codechallenge.git.external.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class GetHottestRepositoryExternalResponseDTO {
	@JsonProperty("total_count")
	private Integer totalCount;
	
	@JsonProperty("incomplete_results")
	private Boolean incompleteResults;
	
	@JsonProperty("items")
	private List<HottestItems> items;
}
