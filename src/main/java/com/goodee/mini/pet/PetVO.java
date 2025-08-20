package com.goodee.mini.pet;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PetVO {

	private Long petNo;
	private Long memNo;
	@NotBlank
	private String petName;
	@NotBlank
	private String petGender;
	@NotBlank
	private String petBreed;
	@NotBlank
	private int petSize;
	@NotBlank
	private int petAge;
	@NotBlank
	private boolean petNeutering;
	@NotBlank
	private String petKind;
	
	private PetFileVO petFileVO;
}
