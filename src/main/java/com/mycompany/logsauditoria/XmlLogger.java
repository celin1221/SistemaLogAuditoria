package com.mycompany.logsauditoria;

import com.mycompany.logsauditoria.interfaces.ILogger;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class XmlLogger implements ILogger{
    
    private String caminhoArquivo;

    public XmlLogger(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public void registrar(LogEntry log) throws IOException{
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)) {

            StringBuilder xml = new StringBuilder();

            xml.append("<log>\n");

            xml.append("  <usuario>").append(log.getUsuario()).append("</usuario>\n");
            xml.append("  <data>").append(log.getData()).append("</data>\n");
            xml.append("  <hora>").append(log.getHora()).append("</hora>\n");
            xml.append("  <operacao>").append(log.getOperacao()).append("</operacao>\n");

            xml.append("  <dados>\n");

            for (Map.Entry<String, String> entry : log.getDados().entrySet()) {
                xml.append("    <").append(entry.getKey()).append(">")
                   .append(entry.getValue())
                   .append("</").append(entry.getKey()).append(">\n");
            }

            xml.append("  </dados>\n");
            xml.append("</log>\n");

            writer.write(xml.toString());

        }
    }
    
}
