package com.game.randomLogs;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLogs {
    private static RandomLogs instance = new RandomLogs();
    private List<String> ataqueAleatorio;
    private List<String> ataquesLogs;
    private List<String> curarseLogs;
    private List<String> esquivarLogs;
    private List<String> noEsquivarLogs;
    Random random;
    private RandomLogs(){
        this.ataqueAleatorio = new ArrayList<>();
        this.ataquesLogs = new ArrayList<>();
        this.curarseLogs = new ArrayList<>();
        this.esquivarLogs = new ArrayList<>();
        this.noEsquivarLogs = new ArrayList<>();
        random = new Random();
        cargarMensajesDesdeArchivo(ataqueAleatorio, "AtaqueAleatorio.txt");
        cargarMensajesDesdeArchivo(ataquesLogs, "AtaquesLogs.txt");
        cargarMensajesDesdeArchivo(curarseLogs, "CurarseLogs.txt");
        cargarMensajesDesdeArchivo(esquivarLogs, "EsquivarLogs.txt");
        cargarMensajesDesdeArchivo(noEsquivarLogs, "NoEsquivarLogs.txt");
    }
    public static RandomLogs getInstance(){
        return instance;
    }
    private void cargarMensajesDesdeArchivo(List<String> list, String nombreArchivo) {
        try {
            Path path = Paths.get("src/com/game/randomLogs/" + nombreArchivo);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            list.addAll(lines);
        } catch (IOException e) {
            System.out.println("No se pudo encontrar el archivo: " + nombreArchivo);
            e.printStackTrace();
        }
    }
    public void logEnemyAtacaPrimero(){
        System.out.println("(i) Enemy ataca primero porque " + ataqueAleatorio.get(random.nextInt(ataqueAleatorio.size())));
    }
    public void logPlayerAtacaPrimero(){
        System.out.println("(i) Player ataca primero porque " + ataqueAleatorio.get(random.nextInt(ataqueAleatorio.size())));
    }
    public String getAtaqueDialogue(){
        return ataquesLogs.get(random.nextInt(ataquesLogs.size()));
    }
    public String getCurarseDialogue(){
        return curarseLogs.get(random.nextInt(curarseLogs.size()));
    }
    public String getEsquivarDialogue(){
        return esquivarLogs.get(random.nextInt(esquivarLogs.size()));
    }
    public String getNoEsquivarDialogue(){
        return noEsquivarLogs.get(random.nextInt(noEsquivarLogs.size()));
    }
}
