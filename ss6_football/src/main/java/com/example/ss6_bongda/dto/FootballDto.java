package com.example.ss6_bongda.dto;

import com.example.ss6_bongda.model.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class FootballDto implements Validator {
    private int id;

    @NotEmpty
    @NotBlank(message = "nhập vào hộ")
    @Size(min = 5, max = 100, message = "độ dài từ 5 đến 100")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "không được xài kí tự đặc biệt")
    private String name;

    @Min(value = 16, message = "chưa đủ tuổi")
    @Max(value = 100, message = "quá già")
    private String birthday;

    private String experience;
    private String location;
    private Team team;

    public FootballDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
