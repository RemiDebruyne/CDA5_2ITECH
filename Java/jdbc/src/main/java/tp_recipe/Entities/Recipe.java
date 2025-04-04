package tp_recipe.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {
    private int id;
    private String name;
    private Time preparationTime;
    private Time cookingTime;
    private int difficulty;
    private int categoryId;
    private Category category;
    private List<Ingredient> ingredients;
}
