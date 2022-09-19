package dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    private Long id;

    @NotBlank
    private String password;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String email;

    @NotBlank
    private String phonenumber;
}
