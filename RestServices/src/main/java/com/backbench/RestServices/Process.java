package com.backbench.RestServices;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import com.backbench.model.ResponseModel;

@Path("/process")
@Produces(MediaType.APPLICATION_JSON)
public class Process {
	ResponseModel responseModel = new ResponseModel();
	@GET
	public ResponseModel getDetails(@Context HttpServletRequest httpRequest,
			@Context HttpHeaders header){
		long startTime = System.currentTimeMillis();
		Date start = new Date();
		waitAndResponse();
		String query = httpRequest.getQueryString()!=null ? getQueryMap(httpRequest.getQueryString()).toString() : null;
		responseModel = new ResponseModel(start.toString(), httpRequest.getMethod(), header.getRequestHeaders().toString(), httpRequest.getPathInfo(), query, null, System.currentTimeMillis()-startTime);
		return responseModel;
	
			}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel getPostDetails(
			String body,
			@Context HttpServletRequest httpRequest,
			@Context HttpHeaders header){
		return getRequestDetails(body,httpRequest,header);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel getPutDetails(String body,
			@Context HttpServletRequest httpRequest,
			@Context HttpHeaders header){
		return getRequestDetails(body,httpRequest,header);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseModel getDeleteDetails(String body,
			@Context HttpServletRequest httpRequest,
			@Context HttpHeaders header){
		return getRequestDetails(body,httpRequest,header);
	}
	
	public static Map<String, String> getQueryMap(String query)  
	 {  
	     String[] params = query.split("&");  
	     Map<String, String> map = new HashMap<String, String>();  
	     for (String param : params)  
	     {  
	         String name = param.split("=")[0];  
	         String value = param.split("=")[1];  
	         map.put(name, value);  
	     }  
	     return map;  
	 }  
	
	public void waitAndResponse(){
		Random r = new Random();
		try {
			Thread.sleep((r.nextInt(30-15) + 15)*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public ResponseModel getRequestDetails(String body,HttpServletRequest httpRequest,
			 HttpHeaders header){
		long startTime = System.currentTimeMillis();
		Date start = new Date();
		JSONObject json = new JSONObject(body);
		waitAndResponse();
		String query = httpRequest.getQueryString()!=null ? getQueryMap(httpRequest.getQueryString()).toString() : null;
		return new ResponseModel(start.toString(), httpRequest.getMethod(), header.getRequestHeaders().toString(), httpRequest.getPathInfo(), query, json.toMap().toString(), System.currentTimeMillis()-startTime);
		
	}
}
