package com.goodee.mini.member;

import java.time.LocalDate;
import java.util.List;

import com.goodee.mini.member.validation.AddGroup;
import com.goodee.mini.member.validation.UpdateGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {
	
	private Long memNo;
	private int authNo;
	@NotBlank(message = "ID는 필수입니다.", groups = AddGroup.class)
	private String memId;
	@NotBlank
	@Size(min = 6, max = 8, groups = AddGroup.class)
	private String memPass;
	private String memPassCheck;
	@NotBlank(groups = {AddGroup.class, UpdateGroup.class})
	private String memName;
	@Email(groups = {AddGroup.class, UpdateGroup.class})
	private String memEmail;
	@Pattern(groups = {AddGroup.class, UpdateGroup.class}, regexp = "^\\d{10,11}$", message = "전화번호는 10자리 또는 11자리 숫자여야 합니다.")
	private String memPhone;
	@NotNull
	@Past(groups = {AddGroup.class, UpdateGroup.class})
	private LocalDate memBirth;
	private String memAddress;
	private boolean enable ;
	
	private List<RoleVO> roleVOs;
}
