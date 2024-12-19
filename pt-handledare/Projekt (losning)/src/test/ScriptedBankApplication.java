package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Supplier;

import bank.BankApplication;

/**
 * Hjälpprogram för att generera LaTeX-formatterad resultatutskrift för
 * studenternas kompendium.
 * 
 * Detta är givetvis inte en del av studenternas uppgift.
 */
public class ScriptedBankApplication extends BankApplication {

    // -----------------------------------------------------------------------
    
    @Override
    protected int readInt(String prompt) {
        return readAndDisplay(() -> super.readInt(prompt));
    }

    @Override
    protected long readLong(String prompt) {
        return readAndDisplay(() -> super.readLong(prompt));
    }

    @Override
    protected double readDouble(String prompt) {
        return readAndDisplay(() -> super.readDouble(prompt));
    }

    @Override
    protected String readLine(String prompt) {
        return readAndDisplay(() -> super.readLine(prompt));
    }

    @Override
    protected void println(Object s) {
        System.out.println(s + "\n");
    }

    private <T> T readAndDisplay(Supplier<T> p) {
        T x = p.get();
        println("\\textbf{" + x + "}");
        return x;
    }

    // -----------------------------------------------------------------------

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("example-input.txt"));
        System.setOut(new PrintStream(new File("../instruktioner/transcript.txt")));
        new ScriptedBankApplication().runApplication();
    }
}
