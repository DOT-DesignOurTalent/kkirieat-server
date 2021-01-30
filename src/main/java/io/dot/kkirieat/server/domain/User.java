package io.dot.kkirieat.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    private User(
            String email,
            String password,
            String nickname,
            Status status,
            Role role
    ) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = status;
        this.role = role;
    }

    public static User signup(
            String email,
            String password,
            String nickname
    ) {
        return new User(
                email,
                password,
                nickname,
                Status.INACTIVE,
                Role.GUEST
        );
    }


    private User(
            String email,
            String password,
            Status status,
            Role role
    ) {
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public static User login(
            String email,
            String password
    ) {
        return new User(
                email,
                password,
                Status.ACTIVE,
                Role.GUEST
        );
    }



    public enum Status {
        ACTIVE, INACTIVE
    }

    public enum Role {
        GUEST, HOST
    }
}
