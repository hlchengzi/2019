package com.xcxu.spring.boot.blog.service.Serverlmpl;

import com.xcxu.spring.boot.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcxu.spring.boot.blog.domain.Vote;
import com.xcxu.spring.boot.blog.repository.VoteRepository;

/**
 * Vote 服务实现.
 * @since 1.0.0 2017年6月6日
 * @author <a href="https://xcxu.com">Way Lau</a> 
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;
    
	@Override
	public Vote getVoteById(Long id) {
		return voteRepository.findOne(id);
	}
	
	@Override
	public void removeVote(Long id) {
		voteRepository.delete(id);
	}

}
