package gui;

import dao.ClienteDAO;
import modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteGUI {
    private JTextField textField1;
    private JButton cadastrarButton;
    private JButton limparButton;
    private JButton sairButton;
    private JPanel panelMain;

    public ClienteGUI() {
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNome(textField1.getText());

                if((textField1.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "O campo não pode retornar vazio");
                } else{
                    ClienteDAO dao = new ClienteDAO();
                    dao.adiciona(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente " + textField1.getText() + " inserido com sucesso!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClienteGUI");
        frame.setContentPane(new ClienteGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
