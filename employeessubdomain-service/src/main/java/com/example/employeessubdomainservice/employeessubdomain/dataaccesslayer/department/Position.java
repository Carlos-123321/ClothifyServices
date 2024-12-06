package com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Embeddable
@Getter
@NoArgsConstructor
public class Position {

    private String title;
    private String code;

    public Position(@NotNull String title, @NotNull String code) {
        this.title = title;
        this.code = code;
    }
}
