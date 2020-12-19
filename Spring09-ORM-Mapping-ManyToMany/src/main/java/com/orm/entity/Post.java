package com.orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name="post_tag_rel",
            joinColumns = {@JoinColumn(name="postId")},
            inverseJoinColumns = {@JoinColumn(name="tagId")})
    private Set<Tag> tags=new HashSet<>(); //in many to many, need to be initialize
    //preferred way use Set for ManyToMany relation ***
    //will create join table for ManyToMany



    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
