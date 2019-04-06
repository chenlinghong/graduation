package com.chenlinghong.graduation.util;

import com.chenlinghong.graduation.api.vo.UserVo;
import com.chenlinghong.graduation.repository.domain.BaseDomain;
import com.chenlinghong.graduation.repository.domain.User;
import org.springframework.stereotype.Service;


/**
 * @Description redis key设计
 * @Author chenlinghong
 * @Date 2019/4/5 13:35
 * @Version V1.0
 */
@Service
public class RedisKeyUtil<T> {

    /**
     * 分隔符
     */
    public static final String SEPARATOR = ":";

    /**
     * 电话号码
     */
    public static final String TELEPHONE = "telephone";

    /**
     * 用户基本信息视图对象
     */
    public static final String USER_INFO = "user_info";

    /**
     * 用户基本信息
     */
    public static final String USER = "user";

    /**
     * 生成redis key，通过domain对象
     * redisKey = {className}:{id}
     *
     * @param data
     * @return
     */
    public String generateKey(T data) {
        if (data == null) {
            return null;
        }
        // data 是 domain领域对象
        if (data instanceof BaseDomain) {
            /**
             * 通过反射，获取到data的类名，实际key的设计为：className:id
             */
            Class clazz = data.getClass();
            String className = clazz.getSimpleName();
            StringBuffer redisKey = new StringBuffer(className);
            redisKey.append(SEPARATOR);
            // 将data强转为BaseDomain
            BaseDomain dataDomain = (BaseDomain) data;
            redisKey.append(dataDomain.getId());
            return redisKey.toString();
        }
        /**
         * 暂不提供其它类的redis key设计
         */
        return null;
    }

    /**
     * 生成redis key
     * 用户基本信息视图对象
     * redisKey = user_info:user:{userId}
     *
     * @param userVo
     * @return
     */
    public String generateKey(UserVo userVo) {
        if (userVo == null) {
            return null;
        }
        // 获取userId
        User userInfo = userVo.getUserInfo();
        if (userInfo == null) {
            return null;
        }
        long userId = userInfo.getId();
        StringBuffer redisKey = new StringBuffer();
        redisKey.append(USER_INFO).append(SEPARATOR).append(USER).append(SEPARATOR).append(userId);
        return redisKey.toString();
    }

    /**
     * 生成redis key。主要针对电话号码进行存储短信验证码
     * redisKey = telephone:{telephone}
     *
     * @param telephone
     * @return
     */
    public String generateKeyForSms(String telephone) {
        StringBuffer redisKey = new StringBuffer();
        redisKey.append(TELEPHONE).append(SEPARATOR).append(telephone);
        return redisKey.toString();
    }
}