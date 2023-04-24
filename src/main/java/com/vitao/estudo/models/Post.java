package com.vitao.estudo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Arrays;

@Document(collection = "estudos")
public class Post {
    private int id;
    private String nome;
    private LocalDateTime data;
    private Double numeroLong;
    private String array[];

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getNumeroLong() {
        return numeroLong;
    }

    public void setNumeroLong(Double numeroLong) {
        this.numeroLong = numeroLong;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", numeroLong=" + numeroLong +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
