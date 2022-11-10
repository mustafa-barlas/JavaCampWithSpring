package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.model.GetByIdModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {

    private ModelService modelService;

    @Autowired
    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/getAll")
    public List<GetAllModelResponse> getAll(){
       return modelService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdModelResponse getById(int id){
        return modelService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);
    }

    @PutMapping("/update")
    public void update(UpdateModelRequest updateModelRequest){
        modelService.update(updateModelRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        modelService.delete(id);
    }
}
