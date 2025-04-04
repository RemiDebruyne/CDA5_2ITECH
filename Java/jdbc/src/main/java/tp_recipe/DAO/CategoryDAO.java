package tp_recipe.DAO;

import tp_recipe.Utils.DatabaseManager;
import tp_recipe.Entities.Category;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAO {
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public Category create(Category category) {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "INSERT INTO categories (name) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getName());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                connection.rollback();
                return null;
            }

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
            }

            connection.commit();
            return category;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Category update(Category category) {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "UPDATE categories SET name=? WHERE id=?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, category.getId());
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return category;
            }

            return null;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Category getById(int id) {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "SELECT * FROM categories WHERE id = ?";
            statement.setInt(1, id);
            statement = connection.prepareStatement(request);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Category(resultSet.getInt("id"), resultSet.getString("name"));
            }

            return null;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Category> getAll() {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "SELECT * FROM categories";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();

            List<Category> categories = new ArrayList<>();

            while (resultSet.next()) {
                categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return categories;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean delete(int id) {
        try (Connection connection = DatabaseManager.getConnection()) {
            request = "DELETE FROM categories WHERE id = ?";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
