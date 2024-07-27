package com.example.presidentElection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profile")

public class UserProfile {
    @Id
    @Column(name = "user_id")
    private Long id;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
