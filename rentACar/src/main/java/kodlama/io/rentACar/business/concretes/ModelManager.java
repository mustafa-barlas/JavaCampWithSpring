package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.model.GetByIdModelResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;

    private BrandRepository brandRepository;

    public ModelManager(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllModelResponse> getAll() {

        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> modelResponses = new ArrayList<>();

        for (Model model : models) {

            GetAllModelResponse responseItem = new GetAllModelResponse();

            responseItem.setId(model.getId());
            responseItem.setName(model.getName());
            responseItem.setBrand(model.getBrand());
            modelResponses.add(responseItem);
        }
        return modelResponses;
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        Model model = modelRepository.findById(id).get();
        GetByIdModelResponse responseItem = new GetByIdModelResponse();

        responseItem.setId(model.getId());
        responseItem.setName(model.getName());
        responseItem.setBrand(model.getBrand());

        return responseItem;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = new Model();
        Brand brand = brandRepository.findById(createModelRequest.getBrandId()).get();
        model.setName(createModelRequest.getName());
        model.setBrand(brand);
        this.modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = new Model();
        Brand brand = brandRepository.findById(updateModelRequest.getBrandId()).get();
        model.setId(updateModelRequest.getId());
        model.setName(updateModelRequest.getName());
        model.setBrand(brand);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
