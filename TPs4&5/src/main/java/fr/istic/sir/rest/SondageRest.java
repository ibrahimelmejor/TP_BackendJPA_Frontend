package fr.istic.sir.rest;

import service.SondageService;
import test.testjpa.domain.SondageFils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/sondages" )
@Consumes(MediaType. APPLICATION_JSON)
@Produces(MediaType. APPLICATION_JSON )
public class SondageRest
{
    SondageService sondageService = new SondageService();
    @GET
    public List<SondageFils> getSondages(@QueryParam("intitule") String intitule, @QueryParam("lieu") String lieu)
    {
        return sondageService.findAllSurveysEntities(intitule,lieu);
    }


}
