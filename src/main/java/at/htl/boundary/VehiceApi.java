package at.htl.boundary;

import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("api/vehicle")
public class VehiceApi {

    @Inject
    VehicleResource vehicleResource;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public TemplateInstance postHtmlForm(
            @FormParam("brand_form") String brand,
            @FormParam("model_form") String model,
            @FormParam("color_form") String color,
            @FormParam("first_registration_form") String firstRegistration
//            ,@FormParam("image_form") InputStream image
    ) {
        System.out.println(brand);
        System.out.println(model);
        System.out.println(color);
        System.out.println(firstRegistration);
        return vehicleResource.listAllVehicles();
    }



}
