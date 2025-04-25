package forum.service;

import forum.model.Comment;
import forum.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByPostId(int postId) {
        return commentRepository.findAllByPost_Id(postId);
    }
}
