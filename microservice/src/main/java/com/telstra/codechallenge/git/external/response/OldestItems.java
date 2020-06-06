package com.telstra.codechallenge.git.external.response;

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
public class OldestItems {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("login")
	private String login;
	
	@JsonProperty("html_url")
	private String htmlUrl;
	
}
