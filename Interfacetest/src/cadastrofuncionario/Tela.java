/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mattg
 */
public class Tela extends javax.swing.JFrame {
    ArrayList<Departamento> listaDep;
    ArrayList<Funcionario> listaFuncs;
    String modoDep;
    String modoFunc;
    
    public void loadTableDep(){
        Object Colunas[] = {"Código","Nome"};       
        DefaultTableModel modelo = new DefaultTableModel(Colunas,0);
        
        for(int i=0;i<listaDep.size();i++){
            Object linha[] = new Object[]{listaDep.get(i).getCodigo(),listaDep.get(i).getNome()};
            modelo.addRow(linha);
        }
        
        tbl_dep_dpts.setModel(modelo);
        
        tbl_dep_dpts.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_dep_dpts.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        loadCBDep();
    }
    
    public void loadTableFunc(){
        Object Colunas[] = {"Matrícula","Nome","Departamento"};       
        DefaultTableModel modelo = new DefaultTableModel(Colunas,0);
        
        for(int i=0;i<listaFuncs.size();i++){
            Object linha[] = new Object[]{listaFuncs.get(i).getMatricula(),listaFuncs.get(i).getNome(), listaFuncs.get(i).getDep().getNome()};
            modelo.addRow(linha);
        }
        
        tbl_func_funcs.setModel(modelo);

        tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_func_funcs.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        loadCBDep();
    }
    
    public void loadCBDep(){
        cb_func_deps.removeAllItems();
        cb_func_deps.addItem("Selecione"); // OBS: fazendo isso o selecione vira o primeiro indice da minha lista (indice 0)
        
        for(int i=0;i<listaDep.size();i++){
            cb_func_deps.addItem(listaDep.get(i).getNome());
            
        }
    }

    /**
     * Creates new form Tela
     */
    public Tela() {
        listaDep = new ArrayList();
        listaFuncs = new ArrayList();
        initComponents();
        
        setLocationRelativeTo(null); // faz a interface aparecer no centro da tela do monitor ***
        
        modoDep = "Navegar";
        modoFunc = "Navegar";
        manipulaInterfaceDep();
        manipulaInterfaceFunc();
    }
    
    public void manipulaInterfaceDep(){
        switch(modoDep){
            case "Navegar":            
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
        
                c_dep_codigo.setEnabled(false);
                c_nome_departamento.setEnabled(false);
        
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
                
            case "Novo":
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);
        
                c_dep_codigo.setEnabled(true);
                c_nome_departamento.setEnabled(true);
        
                btn_dep_novo.setEnabled(false);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);
                break;
                
            case "Editar":
                btn_dep_salvar.setEnabled(true);
                btn_dep_cancelar.setEnabled(true);
        
                c_dep_codigo.setEnabled(true);
                c_nome_departamento.setEnabled(true);
        
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false);                  
                break;
                
            case "Excluir":
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
        
                c_dep_codigo.setEnabled(false);
                c_nome_departamento.setEnabled(false);
        
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(false);
                btn_dep_excluir.setEnabled(false); 
                break;
            case "Selecao":
                btn_dep_salvar.setEnabled(false);
                btn_dep_cancelar.setEnabled(false);
        
                c_dep_codigo.setEnabled(false);
                c_nome_departamento.setEnabled(false);
        
                btn_dep_novo.setEnabled(true);
                btn_dep_editar.setEnabled(true);
                btn_dep_excluir.setEnabled(true);
                break;
                
            default:
                System.out.println("Modo invalido");
        }
    }
    
    public void manipulaInterfaceFunc(){
        switch(modoFunc){
            case "Navegar":  
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                
                c_nome_funcionario.setEnabled(false);
                c_func_matricula.setEnabled(false);
                cb_func_deps.setEnabled(false);
        
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_dfunc_excluir.setEnabled(false);
                break;
                
            case "Novo":
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
        
                c_nome_funcionario.setEnabled(true);
                c_func_matricula.setEnabled(true);
                cb_func_deps.setEnabled(true);
        
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_dfunc_excluir.setEnabled(false);
                break;
                
            case "Editar":
                btn_func_salvar.setEnabled(true);
                btn_func_cancelar.setEnabled(true);
        
                c_nome_funcionario.setEnabled(true);
                c_func_matricula.setEnabled(true);
                cb_func_deps.setEnabled(true);
        
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_dfunc_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                
                c_nome_funcionario.setEnabled(false);
                c_func_matricula.setEnabled(false);
                cb_func_deps.setEnabled(false);
        
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_dfunc_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_func_salvar.setEnabled(false);
                btn_func_cancelar.setEnabled(false);
                
                c_nome_funcionario.setEnabled(false);
                c_func_matricula.setEnabled(false);
                cb_func_deps.setEnabled(false);
        
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(true);
                btn_dfunc_excluir.setEnabled(true);
                break;
                
            default:
                System.out.println("Modo invalido");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btn_func_novo = new javax.swing.JButton();
        btn_func_editar = new javax.swing.JButton();
        btn_dfunc_excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_func_funcs = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_func_matricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_nome_funcionario = new javax.swing.JTextField();
        btn_func_salvar = new javax.swing.JButton();
        btn_func_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_func_deps = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dep_dpts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_dep_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_nome_departamento = new javax.swing.JTextField();
        btn_dep_salvar = new javax.swing.JButton();
        btn_dep_cancelar = new javax.swing.JButton();
        btn_dep_novo = new javax.swing.JButton();
        btn_dep_editar = new javax.swing.JButton();
        btn_dep_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btn_func_novo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_editar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_func_editar.setText("Editar");
        btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editarActionPerformed(evt);
            }
        });

        btn_dfunc_excluir.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_dfunc_excluir.setText("Excluir");
        btn_dfunc_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dfunc_excluirActionPerformed(evt);
            }
        });

        tbl_func_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_func_funcs.getTableHeader().setReorderingAllowed(false);
        tbl_func_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_func_funcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_func_funcs);
        if (tbl_func_funcs.getColumnModel().getColumnCount() > 0) {
            tbl_func_funcs.getColumnModel().getColumn(0).setResizable(false);
            tbl_func_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_func_funcs.getColumnModel().getColumn(1).setResizable(false);
            tbl_func_funcs.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_func_funcs.getColumnModel().getColumn(2).setResizable(false);
            tbl_func_funcs.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Departamento"));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Matrícula:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Nome:");

        btn_func_salvar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_func_salvar.setText("Salvar");
        btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_salvarActionPerformed(evt);
            }
        });

        btn_func_cancelar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_func_cancelar.setText("Cancelar");
        btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("Dep.:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(c_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cb_func_deps, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c_nome_funcionario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_func_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_func_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_func_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_nome_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_func_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_func_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_func_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dfunc_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_novo)
                    .addComponent(btn_func_editar)
                    .addComponent(btn_dfunc_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionários", jPanel1);

        tbl_dep_dpts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dep_dpts.getTableHeader().setReorderingAllowed(false);
        tbl_dep_dpts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dep_dptsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dep_dpts);
        if (tbl_dep_dpts.getColumnModel().getColumnCount() > 0) {
            tbl_dep_dpts.getColumnModel().getColumn(0).setResizable(false);
            tbl_dep_dpts.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_dep_dpts.getColumnModel().getColumn(1).setResizable(false);
            tbl_dep_dpts.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Departamento"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Nome:");

        btn_dep_salvar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_dep_salvar.setText("Salvar");
        btn_dep_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_salvarActionPerformed(evt);
            }
        });

        btn_dep_cancelar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_dep_cancelar.setText("Cancelar");
        btn_dep_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(c_nome_departamento))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btn_dep_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_dep_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_nome_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dep_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btn_dep_novo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_dep_novo.setText("Novo");
        btn_dep_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_novoActionPerformed(evt);
            }
        });

        btn_dep_editar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_dep_editar.setText("Editar");
        btn_dep_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_editarActionPerformed(evt);
            }
        });

        btn_dep_excluir.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btn_dep_excluir.setText("Excluir");
        btn_dep_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dep_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_dep_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dep_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dep_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dep_novo)
                    .addComponent(btn_dep_editar)
                    .addComponent(btn_dep_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Departamentos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dep_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_excluirActionPerformed
        int index = tbl_dep_dpts.getSelectedRow(); // index pega linga e coluna q eu selecionei an interface 
       if(index >=0 && index<listaDep.size()){
           listaDep.remove(index);
           loadTableDep();
       }
        
        modoDep = "Navegar";
        manipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_excluirActionPerformed

    private void btn_dep_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_novoActionPerformed
        c_dep_codigo.setText("");
        c_nome_departamento.setText("");
        modoDep = "Novo";
        manipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_novoActionPerformed

    private void btn_dep_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_cancelarActionPerformed
        c_dep_codigo.setText("");
        c_nome_departamento.setText("");
        modoDep = "Navegar";
        manipulaInterfaceDep();
    }//GEN-LAST:event_btn_dep_cancelarActionPerformed

    private void btn_dep_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_salvarActionPerformed
       int cod = Integer.parseInt(c_dep_codigo.getText());
        if(modoDep.equals("Novo")){
            Departamento D = new Departamento(cod,c_nome_departamento.getText());
        listaDep.add(D);
       }else if(modoDep.equals("Editar")){
           int index = tbl_dep_dpts.getSelectedRow();
           listaDep.get(index).setCodigo(cod);
           listaDep.get(index).setNome(c_nome_departamento.getText());
       }
        loadTableDep();
        modoDep = "Navegar";
        manipulaInterfaceDep();
        c_dep_codigo.setText("");
        c_nome_departamento.setText("");
    }//GEN-LAST:event_btn_dep_salvarActionPerformed

    private void tbl_dep_dptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dep_dptsMouseClicked
       int index = tbl_dep_dpts.getSelectedRow();
       if(index >=0 && index<listaDep.size()){
           Departamento D = listaDep.get(index);
           
           c_dep_codigo.setText(String.valueOf(D.getCodigo()));
           c_nome_departamento.setText(D.getNome());
            
           modoDep = "Selecao";
           manipulaInterfaceDep();
           
       }
    }//GEN-LAST:event_tbl_dep_dptsMouseClicked

    private void btn_dep_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_editarActionPerformed
        modoDep = "Editar";
        manipulaInterfaceDep();
        
    }//GEN-LAST:event_btn_dep_editarActionPerformed

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        modoFunc = "Novo";
        manipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
        modoFunc = "Editar";
        manipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_editarActionPerformed

    private void btn_dfunc_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dfunc_excluirActionPerformed
        modoFunc = "Navegar";
        manipulaInterfaceFunc();
    }//GEN-LAST:event_btn_dfunc_excluirActionPerformed

    private void tbl_func_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_func_funcsMouseClicked
        int index = tbl_func_funcs.getSelectedRow();
        if(index >=0 && index<listaFuncs.size()){
            Funcionario F = listaFuncs.get(index);
            
            c_func_matricula.setText(String.valueOf(F.getMatricula()));
            c_nome_funcionario.setText(F.getNome());
            //cb_func_deps
            
            modoFunc = "Selecao";
            manipulaInterfaceFunc();
        }
    }//GEN-LAST:event_tbl_func_funcsMouseClicked

    private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed
        int index = cb_func_deps.getSelectedIndex();
        if(index == 0){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um departamneto");
        }else{
            if(modoFunc.equals("Novo")){
                Funcionario F = new Funcionario();
                F.setMatricula(Integer.parseInt(c_func_matricula.getText()));
                F.setNome(c_nome_funcionario.getText());
                F.setDep(listaDep.get(index - 1)); // NAO PRECIsARIA DESSA LINHA POIS NO addFunc ele ta seta o Departamaento do determinado funcionario
            
                listaFuncs.add(F);
                listaDep.get(index-1).addFunc(F); // -1 pq o primeiro elemento da lista é o "selecione"
            }else if(modoFunc.equals("Editar")){
                listaFuncs.get(index-1).setMatricula(Integer.parseInt(c_func_matricula.getText()));
                listaFuncs.get(index-1).setNome(c_nome_funcionario.getText());
                //listaFuncs.get(index-1).setDep(cb_func_deps.getToolTipText());
            }
        }
        
        loadTableFunc();
        modoFunc = "Navegar";
        manipulaInterfaceFunc();
        c_func_matricula.setText("");
        c_nome_funcionario.setText("");
       
    }//GEN-LAST:event_btn_func_salvarActionPerformed

    private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
        modoFunc = "Navegar";
        manipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dep_cancelar;
    private javax.swing.JButton btn_dep_editar;
    private javax.swing.JButton btn_dep_excluir;
    private javax.swing.JButton btn_dep_novo;
    private javax.swing.JButton btn_dep_salvar;
    private javax.swing.JButton btn_dfunc_excluir;
    private javax.swing.JButton btn_func_cancelar;
    private javax.swing.JButton btn_func_editar;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_func_salvar;
    private javax.swing.JTextField c_dep_codigo;
    private javax.swing.JTextField c_func_matricula;
    private javax.swing.JTextField c_nome_departamento;
    private javax.swing.JTextField c_nome_funcionario;
    private javax.swing.JComboBox<String> cb_func_deps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_dep_dpts;
    private javax.swing.JTable tbl_func_funcs;
    // End of variables declaration//GEN-END:variables
}
