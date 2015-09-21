package com.spring.util;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class Sample {
	@RequestMapping("/something")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity)
			throws UnsupportedEncodingException {
		String requestHeader = requestEntity.getHeaders().getFirst(
				"MyRequestHeader");
		byte[] requestBody = requestEntity.getBody();
		// do something with request header and body
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		return new ResponseEntity<String>("Hello World", responseHeaders,
				HttpStatus.CREATED);
	}
	@RequestMapping("/do")
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
		}
}
