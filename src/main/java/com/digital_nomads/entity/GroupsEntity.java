package com.digital_nomads.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GroupsEntity {
    private String name;
    private String description;

}
