package at.htl.boundary;

import at.htl.control.VehicleRepository;
import at.htl.entity.Vehicle;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vehicle")
public class VehicleResource {
    @Inject
    VehicleRepository vehicleRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance listvehicles(List<Vehicle> vehicles);
    }

    @GET
    @Path("list")
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get() {
        var vehicles = vehicleRepository.listAll();
        return Templates.listvehicles(vehicles);
    }

    @GET
    public List<Vehicle> getVehicles() {
        return vehicleRepository.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createVehicle(Vehicle vehicle) {
        vehicleRepository.persist(vehicle);
        return Response.created(null).build();
    }

}
