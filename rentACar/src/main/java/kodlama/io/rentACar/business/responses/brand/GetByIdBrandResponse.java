package kodlama.io.rentACar.business.responses.brand;

import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdBrandResponse {

    private int id;
    private String name;
    private List<Model> models;
}
