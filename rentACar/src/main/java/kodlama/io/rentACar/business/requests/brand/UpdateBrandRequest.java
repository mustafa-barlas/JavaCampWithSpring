package kodlama.io.rentACar.business.requests.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBrandRequest {

    private int id;
    private String name;
}
