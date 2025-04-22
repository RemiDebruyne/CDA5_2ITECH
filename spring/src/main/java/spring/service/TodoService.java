package spring.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import spring.model.Todo;

import java.util.Arrays;
import java.util.List;

@Service
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoService {
    private List<Todo> todos = Arrays.asList(
            new Todo("ménage", "faire le ménage", false),
            new Todo("course", "faire les courses", false)
    );

    public Todo getOne(int id){
     return todos.get(id);
    }

    public List<Todo> getAll(){
        return todos;
    }
}
