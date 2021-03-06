package com.majkel.petclinic.services.map;

import com.majkel.petclinic.model.Owner;
import com.majkel.petclinic.model.Pet;
import com.majkel.petclinic.services.OwnerService;
import com.majkel.petclinic.services.PetService;
import com.majkel.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {
        if(object !=null){
            if (object.getPets() !=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else{
                        throw new RuntimeException(("Pet Type is required"));
                    }
                    if(pet.getId()==null){
                        Pet save = petService.save(pet);
                        pet.setId(save.getId());
                    }
                });
            }

        return super.save(object);
        }
        else
            return null;
    }

    @Override
    public Owner findByLastName(String lastname) {
        return null;
    }
}
