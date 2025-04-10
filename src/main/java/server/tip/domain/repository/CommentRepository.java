package server.tip.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import server.tip.domain.Comment;
import server.tip.domain.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);

    @Modifying
    @Query("delete from Comment c where c.post = :post")
    Void deleteByPost(Post post);
}