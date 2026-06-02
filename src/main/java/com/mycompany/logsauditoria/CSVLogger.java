package com.mycompany.logsauditoria;

import com.mycompany.logsauditoria.interfaces.ILogger;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVLogger implements ILogger{
    
    private String caminhoArquivo;

    public CSVLogger(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public void registrar(LogEntry log) throws IOException{
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {

            StringBuilder linha = new StringBuilder();

            // Campos fixos
            linha.append("usuario=").append(log.getUsuario()).append(";");
            linha.append("data=").append(log.getData()).append(";");
            linha.append("hora=").append(log.getHora()).append(";");
            linha.append("operacao=").append(log.getOperacao());

            // Dados dinâmicos (chave=valor)
            for (Map.Entry<String, String> entry : log.getDados().entrySet()) {
                linha.append(";")
                     .append(entry.getKey())
                     .append("=")
                     .append(entry.getValue());
            }

            linha.append("\n");

            writer.write(linha.toString());

        }
    }
    
}
