package com.backbench.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseModel {

	 public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getHeaders() {
		return headers;
	}
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public ResponseModel(){}
	
	public ResponseModel(String time, String method, String headers, String path, String query, String body,
			long duration) {
		this.time = time;
		this.method = method;
		this.headers = headers;
		this.path = path;
		this.query = query;
		this.body = body;
		this.duration = duration;
	}

	public String time; //time when the request was received,
	 public String  method; //HTTP method used for making the request,
	 public String   headers; //HTTP headers in the request,
	public String   path; //request path (will start with /process),
	 public String  query; //the parsed query string as key-values, if any
	 public String  body; //request body, if any
	 public long  duration; //time taken to process the request
}
