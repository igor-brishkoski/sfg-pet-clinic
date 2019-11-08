package brishko.com.sfgpetclinic.services;

import brishko.com.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
