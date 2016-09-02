package com.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResource {

	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(@PathParam("param") String param)
	{
	return "hello "+ param;	
	}
}
