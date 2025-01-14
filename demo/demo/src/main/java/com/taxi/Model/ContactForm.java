package com.taxi.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ContactForm {
    private int id;
    @NotEmpty(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
     @Pattern(regexp = "[a-zA-Z]+", message = "Name can only contain letters")
    private String name;
    @NotEmpty(message = "email is required")
    @Size(min = 2, max = 30, message = "email must be between 2 and 30 characters")
     @Pattern(regexp = "[a-zA-Z]+", message = "Name can only contain letters")
    private String email;
    @NotNull (message = "phone number is required")
    @Min(value = 1000000000, message = "phone number must be at least 10 digits")
    @Max(value = 9999999999L, message = "phone number must be at most 10 digits")
    private long phone;
    @NotEmpty(message = "message is required")
    @Size(min = 2, max = 500, message = "message must be between 2 and 500 characters")
     @Pattern(regexp = "[a-zA-Z]+", message = "message can only contain letters")
    private String message;
    
}
