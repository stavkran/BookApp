package com.novelty.noveltybackend.noveltyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class NoveltyUserController {
    private final NoveltyUserService noveltyUserService;

    @Autowired
    public NoveltyUserController(NoveltyUserService noveltyUserService){
        this.noveltyUserService = noveltyUserService;
    }
    @GetMapping
    public List<NoveltyUser> getUsers(){
        return noveltyUserService.getUsers();
    }
}
