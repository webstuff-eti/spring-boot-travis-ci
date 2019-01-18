package br.eti.webstuff.api.web.controller.responses;

import java.util.List;

import lombok.Data;

@Data
public class Response<T> {

	private T data;
	private List<String> errors;

	public Response() {
	}

}
