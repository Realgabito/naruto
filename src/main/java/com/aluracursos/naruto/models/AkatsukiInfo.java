package com.aluracursos.naruto.models;

public record AkatsukiInfo(
        String id,
        String name
) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n"); 
        
        
        return sb.toString();
    }
}
