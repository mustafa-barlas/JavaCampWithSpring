package kodlama.io.rentACar.business.responses.model;

import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelResponse {

    private int id;
    private String name;
    private Brand brand;
}
