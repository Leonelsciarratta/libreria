package com.example.miAplicacion.Interfaces;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public interface ErrorHandler {
	public String errorHandle(Exception e, ModelMap model);
}

