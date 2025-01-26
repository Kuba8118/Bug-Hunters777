package entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class User {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;

}
