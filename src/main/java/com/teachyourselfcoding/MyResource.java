package com.teachyourselfcoding;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teachyourselfcoding.entity.Contact;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response getIt() {
        //return "Got it!";
    	Contact contact = new Contact();
    	contact.setId(1);
    	contact.setCity("Mumbai");
    	    	
    	return Response.ok(contact).build();
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postIt() {
    	return "RESOURCE CREATED";
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteIt(@PathParam("id") Integer id) {
    	return "DELETE: " + id;
    }
    
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String putIt(@PathParam("id") Integer id) {
    	return "PUT: " + id;
    }
}









