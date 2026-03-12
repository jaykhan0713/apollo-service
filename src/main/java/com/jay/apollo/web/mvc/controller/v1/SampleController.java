package com.jay.apollo.web.mvc.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.apollo.api.v1.sample.SampleApi;
import com.jay.apollo.api.v1.sample.SampleResponse;
import com.jay.apollo.core.context.identity.Identity;
import com.jay.apollo.core.context.identity.IdentityContextHolder;

@RestController
public class SampleController implements SampleApi {

    static final String SUCCESS_MESSAGE = "Sample Endpoint Success.";

    @Override
    @GetMapping("/api/v1/sample")
    public SampleResponse get() {

        Identity identity = IdentityContextHolder.context().identity();

        return new SampleResponse(SUCCESS_MESSAGE, identity.requestId());
    }
}
