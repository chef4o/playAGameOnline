package com.example.pago.services.comment;

import com.example.pago.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void dbImport() {

    }

    @Override
    public boolean dbExists() {
        return this.commentRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return null;
    }
}
