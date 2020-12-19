package com.orm.bootstrap;

import com.orm.entity.Post;
import com.orm.entity.Tag;
import com.orm.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    @Autowired
    PostRepository postRepository;



    @Override
    public void run(String... args) throws Exception {

        Post post= new Post("ORM", "Many to many mapping");
        Post post1= new Post("MVC", "Controller");

        Tag tag= new Tag("Springboot");
        Tag tag1= new Tag("JPA");

        post.getTags().add(tag);
        post.getTags().add(tag1);

        tag.getPosts().add(post);
        tag1.getPosts().add(post);

        tag.getPosts().add(post1);
        post1.getTags().add(tag);

        postRepository.save(post);
        postRepository.save(post1);








    }
}