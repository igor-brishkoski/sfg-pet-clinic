package brishko.com.sfgpetclinic.services.map;

import brishko.com.sfgpetclinic.model.Specialty;
import brishko.com.sfgpetclinic.model.Vet;
import brishko.com.sfgpetclinic.services.SpecialtiesService;
import brishko.com.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null) {
            if(object.getSpecialties() != null) {
                object.getSpecialties().forEach(specialty -> {
                    if(specialty.getId() == null) {
                        Specialty tmp = specialtiesService.save(specialty);
                        specialty.setId(tmp.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
