package steptracking.backend.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ObjectMapperConfiguration {
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        return builder
                .modules(iso8601Serializer())
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
    }

    private Module iso8601Serializer() {
        return new JavaTimeModule()
                .addSerializer(
                        LocalDateTime.class,
                        new JsonSerializer<>() {
                            @Override
                            public void serialize(
                                    LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
                                    throws IOException {
                                String formattedDateTime =
                                        value.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                                gen.writeString(formattedDateTime);
                            }
                        });
    }

    @Bean
    public SimpleDateFormat format() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
}
