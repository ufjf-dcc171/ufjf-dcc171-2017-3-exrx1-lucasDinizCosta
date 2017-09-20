package aula10.exercicioextra;

import javax.swing.JFrame;

/**
 *
 * @author 09937490626 - Lucas Diniz da Costa
 */
public class main {

    public static void main(String[] args) {
        Janela janela = new Janela();
        janela.setSize(500, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

}
