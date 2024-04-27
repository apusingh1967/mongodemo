package com.apu.mongodemo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Document("users")
public class User {
  @Id private String id;
  private int index;
  private String name;
  private boolean isActive;
  private Registered registered;
  private int age;
  private String gender;
  private String eyeColor;
  private String favoriteFruit;
  private Company company;
  private List<String>tags;
}
