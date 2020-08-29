package me.louwrens.quarkus.hibernate;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("api")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CategoryResource {

	@Inject
	EntityManager entityManager;

	@GET
	public List<Category> getCategories() {
		return entityManager.createNamedQuery("Category.findAll", Category.class).getResultList();
	}

	@GET
	@Path("{id}")
	public Category getCategory(@PathParam Long id) {
		Category entity = entityManager.find(Category.class, id);
		if (entity == null) {
			throw new WebApplicationException("Category with id of " + id + " does not exist.", 404);
		}
		return entity;
	}

}
