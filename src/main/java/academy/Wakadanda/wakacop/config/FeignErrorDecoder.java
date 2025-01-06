package academy.Wakadanda.wakacop.config;

import feign.Logger;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import static java.text.MessageFormat.format;
import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = format("An error occurred while calling the API. Status code: {0}, methodKey: {1}",
                response.status(), methodKey);
        if (response.status() == HttpStatus.NOT_FOUND.value())
            LOGGER.warn(message);
        else LOGGER.error(message);
        try {
            return new ResponseStatusException(HttpStatusCode.valueOf(response.status()), response.reason());
        } catch (Exception e) {
            return new Exception("Status code: " + response.status()
            + ", methodKey:" + methodKey.replaceAll("\\(.*\\)", ""));
        }
    }
}
