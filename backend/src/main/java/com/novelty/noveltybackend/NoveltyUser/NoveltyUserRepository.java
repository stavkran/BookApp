package com.novelty.noveltybackend.NoveltyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoveltyUserRepository extends JpaRepository<NoveltyUser, Long> {

}
