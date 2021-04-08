package com.sxxa.hjjczz.util;

/**
 * 系统上下文辅助类
 * @author qifuchao
 *
 */
public class ContextUtil {

    /**
     * 系统http响应中执行状态词
     */
    public final static String HTTP_RESPONSE_STATUS = "status";

    /**
     * 系统http响应中状态对应消息词
     */
    public final static String HTTP_RESPONSE_MESSAGE = "message";

    /**
     * 成功状态词
     */
    public final static String STATUS_SCCESS = "success";

    /**
     * 失败状态词
     */
    public final static String STATUS_FAILED = "failed";

    /**
     * 警告状态词
     */
    public final static String STATUS_WARNING = "warning";

    /**
     * 异常状态词
     */
    public final static String STATUS_EXCEPTION = "exception";

    /**
     * 分页查询-当前查询结果页
     */
    public final static String QUERY_PAGE_INDEX="index";

    /**
     * 分页查询-当前查询结果页返回数据量大小
     */
    public final static String QUERY_PAGE_SIZE="size";

    /**
     * 分页查询-当前查询总共有多少页
     */
    public final static String QUERY_PAGE_COUNT = "count";

    /**
     * 分页查询-当前查询结果总记录数
     */
    public final static String QUERY_DATA_TOTAL = "total";

    /**
     * session中存储登录用户的key
     */
    public final static String SESSION_LOGIN_USER = "userObj";

    /**
     * session是否已存储用户登录信息
     */
    public final static String SESSION_ISLOGIN = "isLogin";

}

