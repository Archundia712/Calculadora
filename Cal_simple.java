package calculadora;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Cal_simple extends JFrame implements ActionListener{
    private JTextField pantalla;
    private double num1, num2, resultado;
    private String operador;

    public Cal_simple() {
        pantalla = new JTextField();
        pantalla.setEditable(false);
        add(pantalla);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
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
        new Calculadora();
    }
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (Character.isDigit(comando.charAt(0))) {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.charAt(0) == '.') {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.charAt(0) == '=') {
            num2 = Double.parseDouble(pantalla.getText());
            realizarOperacion();
            pantalla.setText(String.valueOf(resultado));
            num1 = resultado;
            operador = "";
        } else {
            operador = comando;
            if (!pantalla.getText().equals("")) {
                num1 = Double.parseDouble(pantalla.getText());
                pantalla.setText("");
            }
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