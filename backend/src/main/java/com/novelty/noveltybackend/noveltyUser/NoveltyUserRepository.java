package com.novelty.noveltybackend.noveltyUser;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoveltyUserRepository extends JpaRepository<NoveltyUser, Long> {



}
