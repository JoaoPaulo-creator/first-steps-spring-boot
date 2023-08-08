package com.example.demo.controller;


// classe criada para mensagens customizadas. Sem essa classe, nao esta sendo possivel enviar mensagem em formato de json
// somente texto puro, o que nao me serve neste momento
public class ApiResponse {
    private String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
