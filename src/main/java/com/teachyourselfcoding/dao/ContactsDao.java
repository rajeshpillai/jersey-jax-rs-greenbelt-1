package com.teachyourselfcoding.dao;

import java.util.List;

import com.teachyourselfcoding.entity.Contact;

public interface ContactsDao {
	
	// CRUD
	public Contact addContact(Contact contact) throws DaoException;
	public Contact findById(Integer id) throws DaoException;
	public Contact updateContact(Contact contact) throws DaoException;
	public void deleteContact(Integer id) throws DaoException;
	
	// QUERIES
	public List<Contact> findAll() throws DaoException;
	public List<Contact> findByCity(String city) throws DaoException;
	public List<Contact> findByCountry(String country) throws DaoException;
	
}
