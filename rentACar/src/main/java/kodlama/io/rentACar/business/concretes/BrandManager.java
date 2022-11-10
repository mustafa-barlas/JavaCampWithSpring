package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();

            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());

            responseItem.setModels(brand.getModels());
            brandsResponses.add(responseItem);
        }
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).get();
        GetByIdBrandResponse responseItem = new GetByIdBrandResponse();

        responseItem.setId(brand.getId());
        responseItem.setName(brand.getName());
        responseItem.setModels(brand.getModels());

        return responseItem;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = new Brand();
        brand.setId(updateBrandRequest.getId());
        brand.setName(updateBrandRequest.getName());
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}