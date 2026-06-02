package com.mycompany.logsauditoria;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class LogEntry {

    private String usuario;
    private LocalDate data;
    private LocalTime hora;
    private String operacao;
    private Map<String, String> dados;

    public LogEntry(String usuario, LocalDate data, LocalTime hora,
                    String operacao, Map<String, String> dados) {
        this.usuario = usuario;
        this.data = data;
        this.hora = hora;
        this.operacao = operacao;
        this.dados = dados;
    }

    public String getUsuario() { return usuario; }
    public LocalDate getData() { return data; }
    public LocalTime getHora() { return hora; }
    public String getOperacao() { return operacao; }
    public Map<String, String> getDados() { return dados; }
}