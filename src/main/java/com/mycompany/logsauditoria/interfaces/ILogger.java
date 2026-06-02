package com.mycompany.logsauditoria.interfaces;

import com.mycompany.logsauditoria.LogEntry;
import java.io.IOException;

public interface ILogger {
    void registrar(LogEntry log) throws IOException;
    
}
