package me.louwrens.quarkus.panache;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
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

	@GET
	public List<Category> getCategories() {
		return Category.listAll();
	}

	@GET
	@Path("{id}")
	public Category getCategory(@PathParam Long id) {
		Category entity = Category.findById(id);
		if (entity == null) {
			throw new WebApplicationException("Category with id of " + id + " does not exist.", 404);
		}
		return entity;
	}

}
