package com.ynz.demo.springtestcontextconfiguration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Countries")
@NoArgsConstructor
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long Id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

}
