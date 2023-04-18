import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.Optional;

public class HttpPostFunction {
    @FunctionName("postTestFunction")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse request body
        String requestBody = request.getBody().orElse(null);
        if (requestBody == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Please pass a valid JSON object in the request body.")
                    .build();
        }

        // Process request and create response
        // Replace this with your custom logic, e.g., validate the request data, perform a database operation, etc.
        String result = "You've successfully sent a POST request with the following content: " + requestBody;

        return request.createResponseBuilder(HttpStatus.OK)
                .body(result)
                .build();
    }
}
