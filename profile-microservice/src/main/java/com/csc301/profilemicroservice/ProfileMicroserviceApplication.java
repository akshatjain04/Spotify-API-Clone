package com.csc301.profilemicroservice;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileMicroserviceApplication {

  public static String dbUri = "bolt://localhost:7687";
  public static Driver driver = GraphDatabase.driver(dbUri, AuthTokens.basic("neo4j", "ApzKQdp5*"));

  public static void main(String[] args) {
    SpringApplication.run(ProfileMicroserviceApplication.class, args);

    ProfileDriverImpl.InitProfileDb();
    PlaylistDriverImpl.InitPlaylistDb();

    System.out.println("Profile service is running on port 3002");
  }
}
