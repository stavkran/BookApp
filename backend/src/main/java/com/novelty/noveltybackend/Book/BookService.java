package com.novelty.noveltybackend.Book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final NoveltyUserRepository noveltyUserRepository;

    @Autowired
    public BookService(NoveltyUserRepository noveltyUserRepository){
        this.noveltyUserRepository = noveltyUserRepository;
    }

    public List<NoveltyUser> getUsers(){
        return noveltyUserRepository.findAll();
    }

    public NoveltyUser getUser(Long id){
        Optional<NoveltyUser> user = noveltyUserRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new IllegalStateException("User with ID "+id+" does not exist");
        }
    }

    public void deleteUser(Long id){
        if(noveltyUserRepository.existsById(id)){
            noveltyUserRepository.deleteById(id);
        }else{
            throw new IllegalStateException("User with ID "+id+" does not exist");
        }
    }

    public void addNewUser(NoveltyUser user){
        noveltyUserRepository.save(user);
    }

    @Transactional
    public void updateUser(Long id, String name){
        Optional<NoveltyUser> user = noveltyUserRepository.findById(id);
        if(user.isPresent()){
            if(name != null){
                user.get().setName(name);
            }
        }else{
            throw new IllegalStateException("User with ID "+id+" does not exist");
        }
    }
}
