package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    GetByIdBrandResponse getById(int id);
    void delete(int id);

}
