package com.codegym.validation_form.dto;

import com.codegym.validation_form.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Date;

public class UserDto implements Validator {
    private Integer id;

    @NotEmpty(message = "{empty.error}")
    @Size(min = 5,max = 45)
    private String firstName;

    @NotEmpty(message = "{empty.error}")
    @Size(min = 5,max = 45)
    private String lastName;

    @NotEmpty(message = "{empty.error}")
    private String phoneNumber;

    @NotEmpty(message = "{empty.error}")
    private String dayOfBirth;

    @NotEmpty(message = "{empty.error}")
    @Email(message = "{email.error}")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty","default error");
        if (userDto.phoneNumber.length()>11 || userDto.phoneNumber.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length","default error");
        }
        if (!userDto.phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith","default error");
        }
        if (!userDto.phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches","default error");
        }

        if (!userDto.getDayOfBirth().matches("^20[0-2][0-9]-((0[1-9])|(1[0-2]))-([0-2][1-9]|3[0-1])$")) {
            errors.rejectValue("dayOfBirth", "dayOfBirth.format", "unknown error");
        } else {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdayDate = null;
            Date current = new Date();
            try {
                birthdayDate = fmt.parse(userDto.getDayOfBirth());
                System.out.println(birthdayDate);
                // KIEM TRA NGAY CO TRONG QUA KHU KHONG
                if (birthdayDate != null && birthdayDate.compareTo(new Date()) > 0) {
                    errors.rejectValue("dayOfBirth", "dayOfBirth.after", "unknown dob");
                }
                // KIEM TRA TUOI > 18
                OffsetDateTime startOdt = birthdayDate.toInstant().atOffset(ZoneOffset.UTC);
                OffsetDateTime endOdt = current.toInstant().atOffset(ZoneOffset.UTC);
                int years = Period.between(startOdt.toLocalDate(), endOdt.toLocalDate()).getYears();
                System.out.println(years);
                if (years < 18) {
                    errors.rejectValue("dayOfBirth", "dayOfBirth.under18");
                }
            } catch (ParseException e) {
                e.printStackTrace();
                errors.rejectValue("dayOfBirth", "dayOfBirth.form");
            }
        }
    }
}
