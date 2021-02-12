package net.tillart.restr.user;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {
	
	@Setter @Getter
	private Integer id;
	@Setter @Getter @NonNull
	private String name;
	@Setter @Getter @NonNull
	private Date birthDate;
	
}
