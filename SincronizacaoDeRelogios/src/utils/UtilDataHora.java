package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilDataHora {
	private UtilDataHora () {}
	
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static String agoraFormatado() {
        return LocalDateTime.now().format(FORMATO);
    }

    public static LocalDateTime parse(String dataHora) {
        return LocalDateTime.parse(dataHora, FORMATO);
    }

    public static String formatar(LocalDateTime dataHora) {
        return dataHora.format(FORMATO);
    }
}
