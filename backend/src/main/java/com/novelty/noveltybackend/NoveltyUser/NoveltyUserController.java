package com.novelty.noveltybackend.NoveltyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<NoveltyUser> getAllUsers(){
        return noveltyUserService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public NoveltyUser getUser(@PathVariable("userId") Long id){
        return noveltyUserService.getUser(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody NoveltyUser user){
        noveltyUserService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long id ){
        noveltyUserService.deleteUser(id);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long id, @RequestBody(required = false) NoveltyUser user){
        noveltyUserService.updateUser(id, user.getName());
    }
}
