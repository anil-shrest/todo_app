package com.example.todo;

public class MyTodo {

    String titledoes;
    String datedoes;
    String descdoes;
    String keytodo;

    public MyTodo() {
    }

    public MyTodo(String titledoes, String datedoes, String descdoes, String keytodo) {
        this.titledoes = titledoes;
        this.datedoes = datedoes;
        this.descdoes = descdoes;
        this.keytodo = keytodo;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {

        this.titledoes = titledoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }

    public String getDescdoes() {
        return descdoes;
    }

    public void setDescdoes(String descdoes) {

        this.descdoes = descdoes;
    }
    public String getKeytodo() {
        return keytodo;
    }

    public void setKeytodo(String keytodod) {
        this.keytodo = keytodo;
    }

}
