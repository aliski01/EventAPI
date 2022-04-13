package com.example.eventDemo.EventDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class EventApiController
{

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	EventApiService service;	
	@Autowired 
	HttpEntity<String> entity;

	//Returning all events
	@RequestMapping(value = "/template/events")
	public ResponseEntity<String> getEventsList() 
	{
		String eventUri= service.getUriBuilderForAllEvents();
		System.out.println(eventUri);

		ResponseEntity<String> response = null;

		try 
		{
			response = restTemplate.exchange(eventUri, HttpMethod.GET, entity, String.class);
			System.out.println("response.getStatusCode() :: "+response.getStatusCode());
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occurred " +e.getMessage());
		}	


		return response;
	}

	//Response for specific Event ID
	@RequestMapping(value = "/template/events/{id}")
	public ResponseEntity<String> getEventForId(@PathVariable("id") String id) 
	{

		ResponseEntity< String> response = null;

		String eventUri= service.getUriBuilderForEventById(id);
		System.out.println(eventUri);

		try 
		{
			response = restTemplate.exchange(eventUri, HttpMethod.GET, entity, String.class);
			System.out.println("response.getStatusCode() :: "+response.getStatusCode());
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return response;
	}

	//Search result for a string/keyword
	@RequestMapping(value = "/template/events/q={keyword}") 
	public ResponseEntity<String> getEventsListBySearch(@PathVariable("keyword") String keyword) 
	{

		ResponseEntity<String> response = null;
		String eventUri = service.getUriBuilderSearch(keyword);

		System.out.println(eventUri);
		try 
		{
			response = restTemplate.exchange(eventUri, HttpMethod.GET, entity, String.class);
			System.out.println("response.getStatusCode() :: "+response.getStatusCode());
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}	
		return response;



	}


}





