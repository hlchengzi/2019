/**
 * 
 */
package com.xcxu.spring.boot.blog.service.Serverlmpl;

import com.xcxu.spring.boot.blog.service.AuthorityService;
import com.xcxu.spring.boot.blog.domain.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcxu.spring.boot.blog.domain.Authority;
import com.xcxu.spring.boot.blog.repository.AuthorityRepository;

/**
 * Authority 服务接口的实现.
 * 
 * @since 1.0.0 2017年5月30日
 * @author <a href="https://xcxu.com">Way Lau</a> 
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	/* (non-Javadoc)
	 * @see com.xcxu.spring.boot.blog.service.AuthorityService#getAuthorityById(java.lang.Long)
	 */
	@Override
	public Authority getAuthorityById(Long id) {
		return authorityRepository.findOne(id);
	}

}
