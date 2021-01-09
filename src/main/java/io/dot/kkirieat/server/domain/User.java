package io.dot.kkirieat.server.domain;

import io.dot.kkirieat.server.domain.exception.BadRequestException;
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
    @Column(name = "identifier", nullable = false)
    private String identifier;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "food_tags",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",
                    referencedColumnName = "id"))
    private final Set<FoodTag> foodTags = new HashSet<>();

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;


    private User(
            String email,
            String password,
            String nickname,
            String identifier,
            Status status
    ) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.identifier = identifier;
        this.status = status;
    }

    public static User active(
            String email,
            String password,
            String nickname,
            String identifier
    ) {
        return new User(
                email,
                password,
                nickname,
                identifier,
                Status.ACTIVE
        );
    }

    public void signup(
            String identifier,
            String email,
            String password
    ) {
        if (!this.identifier.equals(identifier)) {
            throw new BadRequestException(String.format("the invitation to '%s' has expired", this.getEmail()));
        }
        this.email = email;
        this.password = password;
    }


    public void isHost() {
    }

    public enum Status {
        GUEST, ACTIVE, INACTIVE, DELETE
    }

}
