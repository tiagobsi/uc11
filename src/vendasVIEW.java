/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tiago
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class vendasVIEW extends JFrame {

    private JTable tabelaVendas;
    private JButton btnVoltar;

    public vendasVIEW() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Consulta de Vendas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Produtos Vendidos");
        lblTitulo.setBounds(230, 10, 200, 25);
        add(lblTitulo);

        tabelaVendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaVendas);
        scrollPane.setBounds(30, 50, 520, 250);
        add(scrollPane);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(250, 320, 100, 25);
        btnVoltar.addActionListener(e -> dispose());
        add(btnVoltar);
    }
    
}
