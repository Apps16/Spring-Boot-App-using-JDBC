package com.example.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This is the model class Employee This represents the table Employee and its
 * fields (name, id, position)
 */

@Setter
@Getter
@ToString
public class Employee {

	@NotBlank
	private String name;

	@NotNull
	@NotBlank
	@Size(max = 10)
	private String id;

	@NotNull
	@NotBlank
	private String position;
}
