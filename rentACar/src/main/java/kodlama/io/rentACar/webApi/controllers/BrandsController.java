package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/getById")
    public GetByIdBrandResponse getById(int id){
        return brandService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }
    @PutMapping("/update")
    public void update(UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        this.brandService.delete(id);
    }
}
