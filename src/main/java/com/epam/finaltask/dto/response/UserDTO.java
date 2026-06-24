package com.epam.finaltask.dto.response;

import java.util.List;


import com.epam.finaltask.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonView(Views.Public.class)
public class UserDTO {

	private String id;

	private String firstName;

    private String lastName;

	private String email;

//    @JsonView(Views.Internal.class)
//    private String password;

    private String role;

    @JsonView(Views.Internal.class)
	private List<VoucherDTO> vouchers;

	private Double balance;

	private boolean active;

}
