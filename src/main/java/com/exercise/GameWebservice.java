package com.exercise;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Web service for ghost game
 */
@Path("/game")
public class GameWebservice {
	/**
	 * Plays next move in form of GET request which produces JSON response
	 *
	 * @param wordString
	 * @return
	 */
    @GET
    @Path("/word/{wordString}")
    @Produces("application/json")
    public Response playNextMove(@PathParam("wordString") String wordString) {
    	//Get object of class implementing player interface
    	Player player = PlayerFactory.getPlayerInstance();

    	//Play next move
    	MoveResult moveResult = player.playNextMove(wordString);

    	//Return response
        return Response.status(200).entity(moveResult).build();
    }
}
