package cn.gmwenterprise.website.bo;

import lombok.Data;

import java.time.*;

/**
 * Article 业务对象
 */
@Data
public class ArticleBo {
    /**
     * PRIMARY KEY<br>
     * AUTO INCREMENT<br>
     * [id] 主键
     */
    private Integer id;
    /**
     * [title] 文章标题
     */
    private String title;
    /**
     * [word_content] 文章文本内容
     */
    private String wordContent;
    /**
     * [markdown_content] 文章MD内容
     */
    private String markdownContent;
    /**
     * [writer] 作者主键
     */
    private Integer writer;
    /**
     * [write_datetime] 创建时间
     */
    private LocalDateTime writeDatetime;
    /**
     * [last_update_datetime] 最后更新时间
     */
    private LocalDateTime lastUpdateDatetime;
}
