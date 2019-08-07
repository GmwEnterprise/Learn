package cn.gmwenterprise.website.config.mybatis.demopageplugin;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageParams {
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页限制条数
     */
    private Integer pageSize;
    /**
     * 是否启动插件，若不启动，则不分页
     */
    private Boolean useFlag;
    /**
     * 是否检测页码有效性，若为true，而页码大于最大页数，抛异常
     */
    private Boolean checkFlag;
    /**
     * 是否清除最后order by后面的语句
     */
    private Boolean cleanOrderBy;
    /**
     * 总条数，插件会回填这个值
     */
    private Integer total;
    /**
     * 总页数，插件会回填这个值
     */
    private Integer totalPage;
}
