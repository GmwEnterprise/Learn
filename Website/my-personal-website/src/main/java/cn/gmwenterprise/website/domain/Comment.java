package cn.gmwenterprise.website.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.*;

/**
 * comment 
 */
@Data
@Alias("comment")
public class Comment {
    /**
     * PRIMARY KEY<br>
     * AUTO INCREMENT<br>
     * [id] 主键
     */
    private Integer id;
    /**
     * [comment_writer] 评论人，account.account_id
     */
    private String commentWriter;
    /**
     * [comment_content] 评论内容
     */
    private String commentContent;
    /**
     * [comment_belong] 评论的文章主键
     */
    private Integer commentBelong;
    /**
     * [create_datetime] 评论时间
     */
    private LocalDateTime createDatetime;
    /**
     * [status] 该条评论状态，1-公开，2-删除
     */
    private Integer status;
}
