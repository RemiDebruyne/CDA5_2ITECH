package tp_recipe.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
    private int id;
    private String name;
    private int ingredientsRecipesId;
}
