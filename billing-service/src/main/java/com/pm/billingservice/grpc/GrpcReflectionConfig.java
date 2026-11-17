package com.pm.billingservice.grpc;

import io.grpc.BindableService;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring gRPC only registers the v1 reflection service (grpc.reflection.v1.ServerReflection).
 * IntelliJ's HTTP Client still uses v1alpha for reflective calls, so expose it as well.
 */
@Configuration
public class GrpcReflectionConfig {

    @Bean
    @SuppressWarnings("deprecation")
    public BindableService protoReflectionServiceV1Alpha() {
        return ProtoReflectionService.newInstance();
    }
}
