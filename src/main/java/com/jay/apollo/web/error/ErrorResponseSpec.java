package com.jay.apollo.web.error;

import org.springframework.http.HttpStatus;

import com.jay.apollo.api.v1.common.error.ErrorResponse;

//used to wrap error response contract with protocol layer response concerns
public record ErrorResponseSpec(HttpStatus status, ErrorResponse body) {}
