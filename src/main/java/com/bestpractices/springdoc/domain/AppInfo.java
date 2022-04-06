package com.bestpractices.springdoc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppInfo {
    private String title;
    private String description;
    private String version;
    private Contact contact;

    @Data
    @NoArgsConstructor
    public static class Contact {
        private String name;
        private String email;
        private String url;
    }
}
