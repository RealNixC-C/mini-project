package com.goodee.mini.pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private Double petSize;
	@NotNull
	private Integer petAge;
	@NotNull
	private boolean petNeutering;
	@NotBlank
	private String petKind;
	
	private PetFileVO petFileVO;
}
