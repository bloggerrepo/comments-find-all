package com.htc.comments.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.comments.entity.Comment;
import com.htc.comments.repo.CommentRepository;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@GetMapping("/comments")
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@PostMapping("/comments")
	public Comment createComment(@RequestBody Comment comment) {
		if (comment.getCreatedAt() == null)
			comment.setCreatedAt(LocalDateTime.now());
		return commentRepository.save(comment);
	}

}
