
package com.mycompany.logsauditoria;

import java.io.FileWriter;
import java.io.IOException;
import com.mycompany.logsauditoria.interfaces.ILogger;
import java.util.Map;


public class JsonLogger implements ILogger{
     private String caminhoArquivo;

    public JsonLogger(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public void registrar(LogEntry log) throws IOException{
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {

            StringBuilder json = new StringBuilder();
            json.append("{");

            json.append("\"usuario\":\"").append(log.getUsuario()).append("\",");
            json.append("\"data\":\"").append(log.getData()).append("\",");
            json.append("\"hora\":\"").append(log.getHora()).append("\",");
            json.append("\"operacao\":\"").append(log.getOperacao()).append("\",");

            json.append("\"dados\":{");

            int i = 0;
            for (Map.Entry<String, String> entry : log.getDados().entrySet()) {
                json.append("\"").append(entry.getKey()).append("\":\"")
                    .append(entry.getValue()).append("\"");

                if (i < log.getDados().size() - 1) {
                    json.append(",");
                }
                i++;
            }

            json.append("}}");
            json.append("\n"); // JSONL

            writer.write(json.toString());

        } 
    }
}
