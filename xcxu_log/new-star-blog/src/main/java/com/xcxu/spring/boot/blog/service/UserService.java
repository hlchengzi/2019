package com.xcxu.spring.boot.blog.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xcxu.spring.boot.blog.domain.User;

/**
 * 用户服务接口.
 * 
 * @since 1.0.0 2017年5月29日
 * @author <a href="https://xcxu.com">Way Lau</a> 
 */
public interface UserService {
	 /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @param user
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 根据用户名集合，查询用户详细信息列表
     * @param usernames
     * @return
     */
    List<User> listUsersByUsernames(Collection<String> usernames);
}