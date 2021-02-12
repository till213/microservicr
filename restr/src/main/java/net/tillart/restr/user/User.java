package net.tillart.restr.user;

import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	@NonNull
	@Size(min = 2)
	private String name;
	@Setter
	@Getter
	@NonNull
	@Past
	private Date birthDate;

}
