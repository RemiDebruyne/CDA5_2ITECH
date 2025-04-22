package spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Todo {
    private String name;
    private String description;
    private boolean isDone;

}
