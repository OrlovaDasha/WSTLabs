package lab6.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WrongIdExceptionMapper implements ExceptionMapper<WrongIdException> {

    @Override
    public Response toResponse(WrongIdException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}

