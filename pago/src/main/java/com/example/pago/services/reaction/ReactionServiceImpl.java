package com.example.pago.services.reaction;

import com.example.pago.repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReactionServiceImpl implements ReactionService {
    private final ReactionRepository reactionRepository;

    @Autowired
    public ReactionServiceImpl(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public void dbImport() {

    }

    @Override
    public boolean dbExists() {
        return reactionRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return null;
    }
}
