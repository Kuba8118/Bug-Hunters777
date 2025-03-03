package entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class CoursesEntity {

    private String courseName;
    private String courseDescription;
}
