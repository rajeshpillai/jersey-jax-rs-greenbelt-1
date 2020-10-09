package com.teachyourselfcoding;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teachyourselfcoding.dao.ContactsDao;
import com.teachyourselfcoding.dao.DaoException;
import com.teachyourselfcoding.dao.DaoFactory;
import com.teachyourselfcoding.entity.Contact;

@Path("/membership")
public class MembershipResource {
	
	private ContactsDao dao;
	
	public MembershipResource() throws DaoException {
		//dao = new JdbcContactsDao(); // BAD practice
		
		dao = DaoFactory.getContactsDao();
	}
	
	@GET
	@Produces({"application/json", "text/csv"})
	public Response getAllContacts() throws DaoException{
		return Response.ok(dao.findAll()).build();
	}
	
	@Path("/{contact_id}")
	@Produces({MediaType.APPLICATION_JSON, "text/csv"  })
	@GET
	public Response getOneContact(@PathParam("contact_id") Integer id) throws DaoException {
		return Response.ok(dao.findById(id)).build();
	}
	
	
	
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewContact(Contact contact) throws DaoException {
		contact = dao.addContact(contact);
		return Response.ok(contact).build();
	}
	
	@Path("/{contact_id}")
	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updateContact(@PathParam("contact_id") Integer id, Contact contact) throws DaoException {
		contact.setId(id);
		contact = dao.updateContact(contact);
		return Response.ok(contact).build();
	}
	
	@DELETE
	@Path("/{contact_id}")
	@Produces({"application/json"})
	public Response deleteContact(@PathParam("contact_id") Integer id) throws DaoException {
		dao.deleteContact(id);
		return Response.ok().build();
	}
}
