package com.xcxu.spring.boot.blog.service.Serverlmpl;

import com.xcxu.spring.boot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcxu.spring.boot.blog.domain.Comment;
import com.xcxu.spring.boot.blog.repository.CommentRepository;

/**
 * Comment Service接口实现.
 * 
 * @since 1.0.0 2017年6月6日
 * @author <a href="https://xcxu.com">Way Lau</a> 
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    
	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}

	@Override
	public void removeComment(Long id) {
		commentRepository.delete(id);
	}

}
