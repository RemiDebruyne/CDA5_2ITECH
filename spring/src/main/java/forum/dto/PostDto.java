package forum.dto;

import forum.model.Comment;
import forum.model.Post;
import forum.model.User;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class PostDto {

    private int id;
    private String title;
    private String content;
    private int authorId;
    private List<CommentDto> comments;

    public static PostDto fromPost(Post post) {
        List<CommentDto> comments = new ArrayList<>();
        for (Comment comment : post.getComments()) {
            comments.add(CommentDto.fromComment(comment));
        }
        return PostDto.builder().id(post.getId()).title(post.getTitle()).content(post.getContent()).authorId(post.getAuthor().getId()).comments(comments).build();
    }
}
