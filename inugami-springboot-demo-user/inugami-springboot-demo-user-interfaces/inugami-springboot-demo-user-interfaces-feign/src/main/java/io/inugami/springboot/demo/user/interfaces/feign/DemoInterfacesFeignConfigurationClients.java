package io.inugami.springboot.demo.user.interfaces.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonEncoder;
import io.inugami.maven.plugin.analysis.annotations.FeignClientDefinition;
import io.inugami.monitoring.springboot.partnerlog.feign.InugamiFeignUtils;
import io.inugami.springboot.demo.user.interfaces.rest.UserRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoInterfacesFeignConfigurationClients {
    @Bean
    public Encoder defaultEncoder(final ObjectMapper objectMapper) {
        return new JacksonEncoder(objectMapper);
    }

    @FeignClientDefinition
    @Bean
    public UserRestClient userRestClient(final Client client,
                                         final Encoder encoder,
                                         final Decoder inugamiFeignDecoder,
                                         final ErrorDecoder feignPartnerErrorDecoder,
                                         final Contract inugamiSpringMvcContract,
                                         @Value("${application.url.userService:http://localhost:8080}") final String baseUrl) {
        return Feign.builder()
                    .client(client)
                    .encoder(encoder)
                    .decoder(inugamiFeignDecoder)
                    .errorDecoder(feignPartnerErrorDecoder)
                    .contract(inugamiSpringMvcContract)
                    .target(UserRestClient.class, InugamiFeignUtils.buildFullPath(UserRestClient.class, baseUrl));
    }
}
