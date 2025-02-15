package com.digital_nomads.page.RandonEntityUtils;

import com.digital_nomads.entity.GroupsEntity;
import com.github.javafaker.Faker;

public class RandomGroupGenerator {
    Faker faker = new Faker();

    public  String randomGroupName(){
        return faker.university().name();

    }
    public String randomCountry(){
        return faker.country().name();
    }

    public GroupsEntity createMockGroup(){
        GroupsEntity groupsEntity = new GroupsEntity();
        groupsEntity.setName(randomGroupName());
        groupsEntity.setDescription(randomCountry());
        return groupsEntity;

    }
}
