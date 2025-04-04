package tp_recipe.DAO;

import tp_recipe.Entities.Ingredient;
import tp_recipe.Utils.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDao {
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public List<Ingredient> getAllIngredientsByRecipeId(int recipeId) {
            try(Connection connection = DatabaseManager.getConnection()) {
                request = "SELECT ingredients.*" +
                        "FROM ingredients" +
                        "JOIN ingredient_recipes ON ingredients.id = ingredient_recipes.ingredient_id" +
                        "WHERE ingredient_recipes.recipe_id = ?";
                statement = connection.prepareStatement(request);
                statement.setInt(1, recipeId);
                resultSet = statement.executeQuery();
                List<Ingredient> ingredients = new ArrayList<>();
                while (resultSet.next()) {
                    ingredients.add(Ingredient.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
                }
                return ingredients;
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
                return null;
            }
    }
}
