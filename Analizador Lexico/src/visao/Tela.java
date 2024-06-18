
package visao;

import controle.Analizador21;
import controle.NumeroLinea;
import controle.Token;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

/**
 * atalhos para sugestao
 *
 * @author Administrator
 */
public class Tela extends javax.swing.JFrame {

    private final NumeroLinea hh;
    private Analizador21 analizador2;
//    private SugestaoJpanel sugestaoJpanel;
    private final List<String> lista;

    private int kk;
    private int y;

    public Tela() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        hh = new NumeroLinea(txtEditor);
        analizador2 = new Analizador21(this);
//        sugestaoJpanel = new SugestaoJpanel();
//        txtEditor.add(sugestaoJpanel);
        lista = new ArrayList<>();
        jScrollPane4.setRowHeaderView(hh);

        jPanel1.remove(jScrollPane1);
        txtEditor.add(jScrollPane1);
        txtEditor.add(tabelaSugestao);
        txtEditor.setText("Program Pzim ;\n"
                + "var r:real;\n"
                + "\n"
                + "procedure media(x,y:real);\n"
                + "var m: real;\n"
                + "begin\n"
                + "m:=(x+y)/2;\n"
                + "writeln(m);\n"
                + "\n"
                + "end;\n"
                + "\n"
                + "procedure y(x,y:real);\n"
                + "var m: real;\n"
                + "begin\n"
                + "m:=(x+y)/2;\n"
                + "Áwriteln(m);\n"
                + "media(13,6665); \n"
                + "end;\n"
                + "Begin\n"
                + "  11y(2,3);\n"
                + "\n"
                + "y(30,20);   \n"
                + "End");
    }

    public JTable getTabela() {
        return jTable1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        lblTimer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSugestao = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblExecutar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaHistoico = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linha", "Token", "Descricao"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        txtEditor.setBackground(new java.awt.Color(204, 204, 255));
        txtEditor.setColumns(20);
        txtEditor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEditor.setLineWrap(true);
        txtEditor.setRows(5);
        txtEditor.setText(" hghgg hjhjh jhhjjh jhjhhjhj jhhjjh hjjhhj nmjhjh  hghgg hjhjh jhhjjh jhjhhjhj jhhjjh hjjhhj nmjhjh  hghgg hjhjh jhhjjh jhjhhjhj jhhjjh hjjhhj nmjhjh  hghgg hjhjh jhhjjh jhjhhjhj jhhjjh hjjhhj nmjhjh  hghgg hjhjh jhhjjh jhjhhjhj jhhjjh hjjhhj nmjhjh ");
        txtEditor.setWrapStyleWord(true);
        txtEditor.setCaretPosition(0);
        txtEditor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEditor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEditorCaretUpdate(evt);
            }
        });
        txtEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEditorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtEditorMouseReleased(evt);
            }
        });
        txtEditor.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtEditorInputMethodTextChanged(evt);
            }
        });
        txtEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEditorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditorKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtEditor);

        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTimer.setText("Timer");

        jLabel1.setText("Linha: 0");

        tabelaSugestao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tabelaSugestao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(186, 186, 186)
                        .addComponent(lblTimer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimer)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        lblExecutar.setText("Executar");
        lblExecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExecutarMouseClicked(evt);
            }
        });

        jLabel2.setText("Resolver Erros");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel2KeyTyped(evt);
            }
        });

        jLabel3.setText("Quebrar linhas");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Ajuda");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MiniPascal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(95, 95, 95)
                .addComponent(lblExecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExecutar)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        txtConsole.setColumns(20);
        txtConsole.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtConsole.setRows(5);
        txtConsole.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Console", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N
        jScrollPane3.setViewportView(txtConsole);

        tabelaHistoico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Historico"
            }
        ));
        jScrollPane5.setViewportView(tabelaHistoico);

        jLabel6.setText("Feito por Claiton Lopes Matavele e Belmiro Chaguala");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        jMenu3.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("jMenuItem1");
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblExecutarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExecutarMouseClicked
        DefaultTableModel tabModel = (DefaultTableModel) jTable1.getModel();
        tabModel.setRowCount(0);
        txtConsole.setText("");
        analizador2.init(txtEditor.getText(), this);
    }//GEN-LAST:event_lblExecutarMouseClicked

    private void txtEditorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEditorMouseReleased

    }//GEN-LAST:event_txtEditorMouseReleased

    private void txtEditorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEditorCaretUpdate

        DefaultTableModel tabModel = (DefaultTableModel) jTable1.getModel();
        tabModel.setRowCount(0);
        txtConsole.setText("");
        analizador2.init(txtEditor.getText(), this);
        String str = "";

        if (txtEditor.getCaretPosition() - 1 > 0) {
            System.out.println(txtEditor.getCaretPosition() - 1);

            System.out.println(
                    txtEditor.getText().substring(
                            0, txtEditor.getCaretPosition() - 1)
            );
            str = txtEditor.getText().substring(
                    Analizador21.posicaoDoUltimoEspaco(
                            txtEditor.getText().substring(
                                    0, txtEditor.getCaretPosition() - 1)
                    ), txtEditor.getCaretPosition() - 1
            );
            lista.add(str);

            //txtConsole.append(Analizador21.posicaoDoUltimoEspaco(txtEditor.getText().substring(0, txtEditor.getCaretPosition() - 1)) + " posicao \n" + txtEditor.getText().length() + "  tamanho");
        }
        pesqusa(new Point(txtEditor.getCaretPosition(), txtEditor.getCaretPosition()), str);
    }//GEN-LAST:event_txtEditorCaretUpdate

    private void txtEditorInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtEditorInputMethodTextChanged
        //   System.out.println(evt.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditorInputMethodTextChanged

    private void txtEditorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorKeyTyped

    }//GEN-LAST:event_txtEditorKeyTyped

    private void txtEditorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEditorMousePressed
        //    System.out.println(evt.getPoint()+" ms2");
    }//GEN-LAST:event_txtEditorMousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        analizador2.resolverErros();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        txtEditor.setLineWrap(!txtEditor.getLineWrap());        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyTyped


    }//GEN-LAST:event_jLabel2KeyTyped

    private void txtEditorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorKeyPressed

    }//GEN-LAST:event_txtEditorKeyPressed

    public void pesqusa(Point point, String str) {
        analizador2.pesquisa(point, str);

//         if (lista.contains(str)) {
//        jList1.setModel(new javax.swing.AbstractListModel<String>() {
//                public int getSize() {
//                    return lista.size();
//                }
//
//                public String getElementAt(int i) {
//                    return lista.get(i).toString();
//                }
//            });
//        }
//        sugestaoJpanel.setVisible(true);

        //System.out.println("Lista de token size: "+lista2.size());
//         sugestaoJpanel.getjList1().setModel(new javax.swing.AbstractListModel<String>() {
//            public int getSize() {
//                return lista2.size();
//            }
//
//            public String getElementAt(int i) {
//                return lista2.get(i).toString();
//            }
//        });
//        sugestaoJpanel.setVisible(true);
    }

    public JTextArea getTxtConsole() {
        return txtConsole;
    }

    public JLabel getLblTimer() {
        return lblTimer;
    }

    public JTextArea getTxtEditor() {
        return txtEditor;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Tela().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblExecutar;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JTable tabelaHistoico;
    private javax.swing.JTable tabelaSugestao;
    private javax.swing.JTextArea txtConsole;
    private javax.swing.JTextArea txtEditor;
    // End of variables declaration//GEN-END:variables

//
//program Fatorial;
//var
//Res, Num : integer;
//begin 
//Res := 1; 
//readln(Num); 
//while Num > 1 do 
//begin
//Res := Res * Num;
//Num := Num - 1
//end; 
//writeln(Res) 
////end.
//end.
//end.
//end.
    public JTable getTabelaSugestao() {
        return tabelaSugestao;
    }

    public JTable getTabelaHistoico() {
        return tabelaHistoico;
    }

//    public SugestaoJpanel getSugestaoJpanel() {
//        return sugestaoJpanel;
//    }

}
