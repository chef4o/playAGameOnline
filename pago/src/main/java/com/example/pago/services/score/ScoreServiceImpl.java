package com.example.pago.services.score;

import com.example.pago.repositories.ScoreRepository;
import com.example.pago.services.init.DatabaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public void dbImport() {

    }

    @Override
    public boolean dbExists() {
        return scoreRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return null;
    }
}
