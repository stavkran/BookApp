package com.novelty.noveltybackend.noveltyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoveltyUserService {
    private final NoveltyUserRepository noveltyUserRepository;

    @Autowired
    public NoveltyUserService(NoveltyUserRepository noveltyUserRepository){
        this.noveltyUserRepository = noveltyUserRepository;
    }

    public List<NoveltyUser> getUsers(){
        return noveltyUserRepository.findAll();
    }
}
