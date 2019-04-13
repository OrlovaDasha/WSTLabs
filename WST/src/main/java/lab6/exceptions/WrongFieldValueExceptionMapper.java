package lab6.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class WrongFieldValueExceptionMapper implements ExceptionMapper<WrongFieldValueException> {

    @Override
    public Response toResponse(WrongFieldValueException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
