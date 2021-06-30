package ru.service.helloworldrestful.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greeting {
    private final long id;
    private final String content;
    private final Integer age;
}
