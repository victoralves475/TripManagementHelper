/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author antoniovictoralvesdacosta
 */
public class ListaExcursao extends javax.swing.JPanel {

    /**
     * Creates new form ListExcursion
     */
    public ListaExcursao(ArrayList<String> resultado, Double preco, Double total) {
        this.resultado = resultado;
        this.preco = preco;
        this.total = total;
        initComponents();
        print();
    }

//    private void print() {
//        
//        String listaCPF = "";
//        String listaNome = "";
//        String listaPreco = "";
//        String[] aux;
//        for (String ocorrencia : resultado) {
//            aux = ocorrencia.split("/");
//            listaCPF += ("   " + aux[0] + "\n");
//            listaNome += ("   " + aux[1] + "\n");
//            listaPreco += ("   " + this.preco+ "\n");
//        }
//        
//        printCPF.setText(listaCPF);
//        printNome.setText(listaNome);
//        printPreco.setText(listaPreco);
//        printTotal.setText(Double.toString(total));
//        
//    }
    private void print() {

        String listaCPF = "\n";
        String listaNome = "\n";
        String listaPreco = "\n";
        String[] aux;

        // Configura a formatação para o padrão brasileiro
        NumberFormat formatador = NumberFormat.getInstance(new Locale("pt", "BR"));
        formatador.setMinimumFractionDigits(2);
        formatador.setMaximumFractionDigits(2);

        for (String ocorrencia : resultado) {
            aux = ocorrencia.split("/");
            listaCPF += ("   " + aux[0] + "\n");
            listaNome += ("   " + aux[1] + "\n");

            String precoFormatado = formatador.format(this.preco);
            listaPreco += ("   " + precoFormatado + "\n");
        }

        printCPF.setText(listaCPF);
        printNome.setText(listaNome);
        printPreco.setText(listaPreco);

        String valorFormatado = formatador.format(total);
        printTotal.setText(valorFormatado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        printTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        scrollPaneWin111 = new raven.scroll.win11.ScrollPaneWin11();
        printCPF = new javax.swing.JTextArea();
        scrollPaneWin112 = new raven.scroll.win11.ScrollPaneWin11();
        printNome = new javax.swing.JTextArea();
        scrollPaneWin113 = new raven.scroll.win11.ScrollPaneWin11();
        printPreco = new javax.swing.JTextArea();

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CPF");

        jLabel2.setBackground(new java.awt.Color(250, 250, 250));
        jLabel2.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOME");

        jLabel3.setBackground(new java.awt.Color(250, 250, 250));
        jLabel3.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PREÇO");

        printTotal.setBackground(new java.awt.Color(250, 250, 250));
        printTotal.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        printTotal.setForeground(new java.awt.Color(51, 102, 255));
        printTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel5.setBackground(new java.awt.Color(250, 250, 250));
        jLabel5.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelTotal.setBackground(new java.awt.Color(250, 250, 250));
        jLabelTotal.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(51, 102, 255));
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText("Total: ");

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        printCPF.setColumns(20);
        printCPF.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        printCPF.setRows(5);
        printCPF.setBorder(null);
        printCPF.setFocusable(false);
        scrollPaneWin111.setViewportView(printCPF);

        scrollPaneWin112.setBorder(null);
        scrollPaneWin112.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        printNome.setColumns(20);
        printNome.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        printNome.setRows(5);
        printNome.setBorder(null);
        printNome.setFocusable(false);
        scrollPaneWin112.setViewportView(printNome);

        scrollPaneWin113.setBorder(null);
        scrollPaneWin113.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        printPreco.setColumns(20);
        printPreco.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        printPreco.setRows(5);
        printPreco.setBorder(null);
        printPreco.setFocusable(false);
        scrollPaneWin113.setViewportView(printPreco);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(242, 242, 242))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(scrollPaneWin113, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneWin113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(printTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<String> resultado;
    private Double preco;
    private Double total;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea printCPF;
    private javax.swing.JTextArea printNome;
    private javax.swing.JTextArea printPreco;
    private javax.swing.JLabel printTotal;
    private raven.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    private raven.scroll.win11.ScrollPaneWin11 scrollPaneWin112;
    private raven.scroll.win11.ScrollPaneWin11 scrollPaneWin113;
    // End of variables declaration//GEN-END:variables
}
