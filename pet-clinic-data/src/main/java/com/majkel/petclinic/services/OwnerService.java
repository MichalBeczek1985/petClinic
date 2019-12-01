package com.majkel.petclinic.services;

import com.majkel.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastname);
}
