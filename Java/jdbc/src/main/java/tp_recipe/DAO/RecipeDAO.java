package tp_recipe.DAO;

import tp_recipe.Entities.Recipe;
import tp_recipe.Utils.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;
    private IngredientDao ingredientDao = new IngredientDao();

    public Recipe create(Recipe recipe) {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "Insert into recipe (name, preparation_time, cooking_time, difficulty, " +
                    "categoryId) values(?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(request);
            statement.setString(1, recipe.getName());
            statement.setTime(2, recipe.getPreparationTime());
            statement.setTime(3, recipe.getCookingTime());
            statement.setInt(4, recipe.getDifficulty());
            statement.setInt(5, recipe.getCategoryId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                connection.rollback();
                return null;
            }

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                recipe.setId(resultSet.getInt("id"));
            }

            connection.commit();
            return recipe;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Recipe update(Recipe recipe) {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "UPDATE categories SET name=?, preparation_time=?, cooking_time=?, " +
                    "difficulty=?, categoryId=?" +
                    " WHERE" +
                    " " +
                    "id=?";
            statement = connection.prepareStatement(request);
            statement.setString(1, recipe.getName());
            statement.setTime(2, recipe.getPreparationTime());
            statement.setTime(3, recipe.getCookingTime());
            statement.setInt(4, recipe.getDifficulty());
            statement.setInt(5, recipe.getCategoryId());
            statement.setInt(6, recipe.getId());

            int affectedRow = statement.executeUpdate();

            if (affectedRow != 1) {
                connection.rollback();
            }

            connection.commit();
            return recipe;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Recipe> getAll() {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "SELECT * FROM recipes";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            List<Recipe> recipes = new ArrayList<>();
            while (resultSet.next()) {
                recipes.add(Recipe.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString(
                        "name"))
                        .preparationTime(resultSet.getTime("preparation_time"))
                        .cookingTime(resultSet.getTime("cooking_time"))
                        .difficulty(resultSet.getInt("difficulty"))
                        .ingredients(ingredientDao.getAllIngredientsByRecipeId(resultSet.getInt("id")))
                        .build());
            }
        return recipes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
