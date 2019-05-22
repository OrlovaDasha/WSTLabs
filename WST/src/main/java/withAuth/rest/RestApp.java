package withAuth.rest;


import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;
import java.net.URI;

import static com.sun.jersey.api.core.ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS;

public class RestApp {
    private static final URI BASE_URI = URI.create("http://localhost:8081/rest/");

    public static void main(String[] args) {
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new ClassNamesResourceConfig(FilmCrudResource.class, AuthenticationFilter.class);
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            resourceConfig.getProperties().put(PROPERTY_CONTAINER_REQUEST_FILTERS, new AuthenticationFilter());
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}
