package org.acme.resteasy;

import org.acme.resteasy.entities.ClassicCarEntity;
import org.acme.resteasy.springdata.ClassicCarRepository;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/resteasy/hello")
public class ExampleResource {

    @Inject
    ClassicCarRepository classicCarRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Path("cars/classic/{brandId}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String classicCars(@PathParam("brandId") String brandId) {
        List<ClassicCarEntity> cars = classicCarRepository.findByCarBrandId(brandId);
        return cars.stream().map(ClassicCarEntity::getName).collect(Collectors.joining(", "));
    }

    @Path("cars/classic/brandIds")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String classicCars() {
        List<String> carBrandIds = classicCarRepository.findAllUsedCarBrandIds();
        return carBrandIds.stream().collect(Collectors.joining(", "));
    }
}