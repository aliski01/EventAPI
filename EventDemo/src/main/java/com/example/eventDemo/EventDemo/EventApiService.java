package com.example.eventDemo.EventDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
@Service
public class EventApiService {
	
	@Value("${event_url}")
	private String eventUrl;

	@Value("${client_id}")
	private String clientId;

	@Value("${client_secret}")
	private String secretId;
	
		
	public String getEventUrl() {
		return eventUrl;
	}

	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getUriBuilderForAllEvents()
	{
		 UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(eventUrl)
		 .queryParam("client_id",clientId) 
		 .queryParam("client_secret",secretId);
		 
		return builder.toUriString();
	}
	
	public String getUriBuilderForEventById(String id)
	{
		String tempEventUrl = eventUrl + "/" +id; 
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(tempEventUrl)
		 .queryParam("client_id",clientId) 
		 .queryParam("client_secret",secretId);
		 
		return builder.toUriString();
	}
	
	public String getUriBuilderSearch(String keyword)
	{
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(eventUrl)
		 .queryParam("client_id",clientId) 
		 .queryParam("client_secret",secretId)
		 .queryParam("q", keyword);
		 
		return builder.toUriString();
	}
}
