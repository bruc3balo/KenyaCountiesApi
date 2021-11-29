package com.counties.kenya.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class JsonResponse2 {
	private boolean success;
	private boolean has_error;
	private int api_code;
	private String api_code_description;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String trx_id;

	private Page2 data;


	public JsonResponse2() {
		super();
	}

	public JsonResponse2(boolean success, boolean has_error, int api_code, String api_code_description,
                         String message, String trx_id, Page2 data) {
		super();
		this.success = success;
		this.has_error = has_error;
		this.api_code = api_code;
		this.api_code_description = api_code_description;
		this.message = message;
		this.trx_id = trx_id;
		this.data = data;
	}
}
