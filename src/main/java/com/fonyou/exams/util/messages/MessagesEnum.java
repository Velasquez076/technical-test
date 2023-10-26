package com.fonyou.exams.util.messages;

import lombok.Getter;

/**
 * 
 * @author Julián Velásquez
 *
 */
public enum MessagesEnum {

	CREATED_SUCCESS(201, "El examen fue registrado con éxito!"),
	STUDENT_CREATED(201, "El estudiante fue registrado con éxito!"),
	SERVER_ERROR(500,"A ocurrido un error inesperado, contacta al administrador!"),
	TIME_ZONE_INVALID(400, "El timezone ingresado es inválido!"),
	EXAM_NOT_FOUND(404, "El examen a asignar no existe!"),
	ASSIGN_SUCCESS(200, "Examen fue asignado en la fecha y zona horaria con éxito!"),
	SUCCESS(200, "Respuesta éxitosa!"),
	SIZE_INVALID(400, "El cuestionario debe tener 03 preguntas!"),
	DATE_INVALID(400, "La fecha ingresada tiene un patrón invalido! :: Valid -> 2023-01-01T00:00:00.333Z!"),
	RESPONSE_SUCCESS(201, "Respuestas almacenadas con éxito!"),
	STUDENT_NOT_FOUNT(404, "El estudiante con el id ingresado no existe!"),
	EXAM_ANOT_FOUND(404, "El examen con id ingresado no existe!"),
	FIELD_NOT_NULL(400, "El campo '%s' es requerido!");

	@Getter
	private int code;

	@Getter
	private String message;

	private MessagesEnum(int code, String message) {
		this.code = code;
		this.message = message;

	}
}
