package forum.dto;

import forum.model.Comment;
import forum.model.Post;
import forum.model.User;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class CommentDto {
    private int id;
    private String content;
    private User author;
    private PostDto post;
    private List<CommentDto> children;

    public static CommentDto fromComment(Comment comment) {
        List<CommentDto> children = new ArrayList<>();
        for (Comment child : comment.getChildren()) {
            children.add(CommentDto.fromComment(child));
        }
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .author(comment.getAuthor())
                .post(PostDto.fromPost(comment.getPost()))
                .children(children)
                .build();
    }
}
