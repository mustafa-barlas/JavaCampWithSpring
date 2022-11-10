package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelResponse;
import kodlama.io.rentACar.business.responses.model.GetByIdModelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {

    List<GetAllModelResponse> getAll();

    GetByIdModelResponse getById(int id);

    void add(CreateModelRequest createModelRequest);

    void update(UpdateModelRequest updateModelRequest);

    void delete(int id);
}
