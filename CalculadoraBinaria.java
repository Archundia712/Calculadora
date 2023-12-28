package calculadora;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraBinaria extends JFrame implements ActionListener {
    private JTextField pantalla;
    private String operador;
    private int num1, num2, resultado;

    public CalculadoraBinaria() {
        pantalla = new JTextField();
        pantalla.setEditable(false);
        add(pantalla);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        String[] botones = {
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "0", "/", "=", "C"
        };
        for (String boton : botones) {
            JButton btn = new JButton(boton);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraBinaria();
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "=":
                num2 = Integer.parseInt(pantalla.getText(), 2);
                realizarOperacion();
                pantalla.setText(Integer.toBinaryString(resultado));
                num1 = resultado;
                operador = "";
                break;
            case "C":
                pantalla.setText("");
                num1 = 0;
                num2 = 0;
                resultado = 0;
                operador = "";
                break;
            default:
                pantalla.setText(pantalla.getText() + comando);
                break;
        }
    }

    private void realizarOperacion() {
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    pantalla.setText("Error");
                }
                break;
        }
    }
}