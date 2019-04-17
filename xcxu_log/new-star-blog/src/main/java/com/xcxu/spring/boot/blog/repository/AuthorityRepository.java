package com.xcxu.spring.boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcxu.spring.boot.blog.domain.Authority;

/**
 * Authority 仓库.
 * 
 * @since 1.0.0 2017年5月30日
 * @author <a href="https://xcxu.com">Way Lau</a> 
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
