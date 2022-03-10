package exchangeratesapi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@OpenAPIDefinition(
    info = @Info(
        title = "Exchange Rate - API",
        version = "1.0"
    ),
    security = @SecurityRequirement(name = "jwt", scopes = {"admin"}),
    components = @Components(
        securitySchemes = {
            @SecurityScheme(
                securitySchemeName = "jwt",
                type = SecuritySchemeType.APIKEY,
                apiKeyName = "Authorization",
                bearerFormat = "Bearer",
                in = SecuritySchemeIn.HEADER
            )
        }
    ))
@QuarkusMain
@ApplicationPath("/")
public class MainApplication extends Application {
	
    public static void main(String[] args) {
        Quarkus.run(args);
    }
}