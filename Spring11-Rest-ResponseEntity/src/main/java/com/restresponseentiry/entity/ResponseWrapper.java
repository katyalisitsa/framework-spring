package com.restresponseentiry.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    private boolean success;
    private String message;
}
