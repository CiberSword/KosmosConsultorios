package com.cibersword.kosmosconsultorios.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResponseHandler {

    private static final Set<HttpStatus> SUCCESS_STATUSES = new HashSet<>() {{
        add(HttpStatus.OK);
        add(HttpStatus.CREATED);
    }};

    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", SUCCESS_STATUSES.contains(status));
        map.put("msg", status.getReasonPhrase());
        map.put("data", responseObj);
        return new ResponseEntity<>(map, status);
    }
}
