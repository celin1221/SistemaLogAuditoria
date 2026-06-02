package com.mycompany.logsauditoria;

import com.mycompany.logsauditoria.interfaces.ILogger;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Logsauditoria {

    public static void main(String[] args) {
        ILogger loggerJson = new JsonLogger("log.jsonl");
        ILogger loggerCsv = new CSVLogger("log.csv");
        ILogger loggerXml = new XmlLogger("log.xml");

        Map<String, String> dados = new HashMap<>();
        dados.put("acao", "teste_log");
        dados.put("status", "sucesso");
        dados.put("id", "001");

        LogEntry log = new LogEntry(
            "usuario_teste",
            LocalDate.now(),
            LocalTime.now(),
            "Teste do sistema de log",
            dados
        );

         try {
            loggerJson.registrar(log);
            loggerCsv.registrar(log);
            loggerXml.registrar(log);

            System.out.println("Logs gerados com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao gerar logs: " + e.getMessage());
        }
    }
}
