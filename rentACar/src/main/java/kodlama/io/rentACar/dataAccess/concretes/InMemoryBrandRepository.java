package kodlama.io.rentACar.dataAccess.concretes;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"BMW"));
        brands.add(new Brand(2,"AUDİ"));
        brands.add(new Brand(3,"PORSCHE"));
        brands.add(new Brand(4,"JAGUAR"));
        brands.add(new Brand(5,"MASERATİ"));
        brands.add(new Brand(6,"ALFA ROMEO"));

    }
    @Override
    public List<Brand> getAll() {
        return brands;
    }
}
