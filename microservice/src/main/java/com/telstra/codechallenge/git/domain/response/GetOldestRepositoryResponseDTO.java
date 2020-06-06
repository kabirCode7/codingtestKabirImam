package com.telstra.codechallenge.git.domain.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telstra.codechallenge.git.external.response.OldestItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown= true)
public class GetOldestRepositoryResponseDTO {
	
	List<OldestItems> oldestItemList;
	
}
