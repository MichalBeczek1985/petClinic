package com.majkel.petclinic.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Speciality extends BaseEntity {
    private String description;
}
