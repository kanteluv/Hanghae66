package com.sparta.hanghae66.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;




@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="comment_id")
    private Long commentId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String content;

    @ColumnDefault("0")
    private Long commentLikes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comment (String content, String userId) {
        this.content = content;
        this.userId = userId;
    }

    public void update(String content) {
        this.content = content;
    }
}
