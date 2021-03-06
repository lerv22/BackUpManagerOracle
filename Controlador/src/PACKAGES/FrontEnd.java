package PACKAGES;

import static PACKAGES.ConstructorFiles.RmanFull;
import static PACKAGES.ConstructorFiles.RmanIncremental;
import static PACKAGES.ConstructorFiles.RmanWhole;
import static PACKAGES.DBManager.getNameFromDB;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FrontEnd extends javax.swing.JFrame {

    public FrontEnd() throws ExceptionInInitializerError {
        this.tbs = new DefaultListModel();
        initComponents();
        if (tbs()) {
            tablespaces_lst.setSelectionModel(new DefaultListSelectionModel() {
                private static final long serialVersionUID = 1L;
                boolean gestureStarted = false;

                @Override
                public void setSelectionInterval(int index0, int index1) {
                    if (!gestureStarted) {
                        if (isSelectedIndex(index0)) {
                            super.removeSelectionInterval(index0, index1);
                        } else {
                            super.addSelectionInterval(index0, index1);
                        }
                    }
                    gestureStarted = true;
                }

                @Override
                public void setValueIsAdjusting(boolean isAdjusting) {
                    if (isAdjusting == false) {
                        gestureStarted = false;
                    }
                }
            });
        }else{
            throw new ExceptionInInitializerError("Database not available");
        }
        table.setAutoCreateRowSorter(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modes_group = new javax.swing.ButtonGroup();
        incLevel_group = new javax.swing.ButtonGroup();
        jMenuItem4 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        strategy_pnl = new javax.swing.JPanel();
        header_pnl = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        name_mode_pnl = new javax.swing.JPanel();
        stragedy_txt = new javax.swing.JTextField();
        type_lbl = new javax.swing.JLabel();
        full_rnd = new javax.swing.JRadioButton();
        incremetnal_rnd = new javax.swing.JRadioButton();
        total_rnd = new javax.swing.JRadioButton();
        name_lbl = new javax.swing.JLabel();
        lvl_1_rnd = new javax.swing.JRadioButton();
        lvl_0_rnd = new javax.swing.JRadioButton();
        level_lbl = new javax.swing.JLabel();
        tbs_time_pnl = new javax.swing.JPanel();
        date_txt = new javax.swing.JTextField();
        addEvt_btn = new javax.swing.JButton();
        delteEvt_btn = new javax.swing.JButton();
        time_lbl = new javax.swing.JLabel();
        tablespace_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablespaces_lst = new javax.swing.JList();
        note_lbl = new javax.swing.JLabel();
        createStrategy_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        db_include_pnl = new javax.swing.JPanel();
        database_lbl = new javax.swing.JLabel();
        databases_cmb = new javax.swing.JComboBox();
        control_chk = new javax.swing.JCheckBox();
        archive_chk = new javax.swing.JCheckBox();
        include_lbl = new javax.swing.JLabel();
        viewer_pnl = new javax.swing.JPanel();
        table_pnl = new javax.swing.JPanel();
        header2_pnl = new javax.swing.JPanel();
        banner_lbl = new javax.swing.JLabel();
        filter_pnl = new javax.swing.JPanel();
        filter_txt = new javax.swing.JTextField();
        filter_btn = new javax.swing.JButton();
        delete_txt = new javax.swing.JTextField();
        delete_btn = new javax.swing.JButton();
        tables_scroll_pnl = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        Help = new javax.swing.JMenu();
        time_drd = new javax.swing.JMenuItem();
        licenses_drd = new javax.swing.JMenuItem();
        third_party_drd = new javax.swing.JMenuItem();
        about_drd = new javax.swing.JMenuItem();
        fork_us_drd = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NARF BU Manager");
        setResizable(false);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/banner.png"))); // NOI18N

        javax.swing.GroupLayout header_pnlLayout = new javax.swing.GroupLayout(header_pnl);
        header_pnl.setLayout(header_pnlLayout);
        header_pnlLayout.setHorizontalGroup(
            header_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        header_pnlLayout.setVerticalGroup(
            header_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
        );

        type_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        type_lbl.setForeground(new java.awt.Color(0, 0, 0));
        type_lbl.setText("BackUp Mode");

        modes_group.add(full_rnd);
        full_rnd.setSelected(true);
        full_rnd.setText("Full BackUp");
        full_rnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_change(evt);
            }
        });

        modes_group.add(incremetnal_rnd);
        incremetnal_rnd.setText("Incremental BackUp");
        incremetnal_rnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_change(evt);
            }
        });

        modes_group.add(total_rnd);
        total_rnd.setText("Whole BackUp");
        total_rnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_change(evt);
            }
        });

        name_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        name_lbl.setForeground(new java.awt.Color(0, 0, 0));
        name_lbl.setText("Name of Strategy");

        incLevel_group.add(lvl_1_rnd);
        lvl_1_rnd.setText("1");
        lvl_1_rnd.setEnabled(false);

        incLevel_group.add(lvl_0_rnd);
        lvl_0_rnd.setSelected(true);
        lvl_0_rnd.setText("0");
        lvl_0_rnd.setEnabled(false);

        level_lbl.setText("Level");
        level_lbl.setEnabled(false);

        javax.swing.GroupLayout name_mode_pnlLayout = new javax.swing.GroupLayout(name_mode_pnl);
        name_mode_pnl.setLayout(name_mode_pnlLayout);
        name_mode_pnlLayout.setHorizontalGroup(
            name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(name_mode_pnlLayout.createSequentialGroup()
                .addGroup(name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(name_mode_pnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name_lbl))
                    .addGroup(name_mode_pnlLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(stragedy_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88)
                .addGroup(name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(name_mode_pnlLayout.createSequentialGroup()
                        .addComponent(full_rnd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_rnd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incremetnal_rnd, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(name_mode_pnlLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(level_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lvl_0_rnd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lvl_1_rnd)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        name_mode_pnlLayout.setVerticalGroup(
            name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(name_mode_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_lbl)
                    .addComponent(type_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stragedy_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_rnd)
                    .addComponent(full_rnd)
                    .addComponent(incremetnal_rnd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(name_mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvl_1_rnd)
                    .addComponent(lvl_0_rnd)
                    .addComponent(level_lbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        date_txt.setEditable(false);

        addEvt_btn.setText("Add Event");
        addEvt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEvt_btnActionPerformed(evt);
            }
        });

        delteEvt_btn.setText("Delete All Events");
        delteEvt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delteEvt_btnActionPerformed(evt);
            }
        });

        time_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        time_lbl.setForeground(new java.awt.Color(0, 0, 0));
        time_lbl.setText("Date & Time");

        tablespace_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        tablespace_lbl.setForeground(new java.awt.Color(0, 0, 0));
        tablespace_lbl.setText("Tablespace");

        tablespaces_lst.setModel(tbs);
        tablespaces_lst.setSelectedIndex(1);
        tablespaces_lst.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jScrollPane1.setViewportView(tablespaces_lst);

        note_lbl.setText("*Select by clicking the item, you can select");

        createStrategy_btn.setBackground(new java.awt.Color(102, 102, 255));
        createStrategy_btn.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        createStrategy_btn.setText("Create Strategy");
        createStrategy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStrategy_btnActionPerformed(evt);
            }
        });

        jLabel1.setText("many, reclick to deselect the tablespace");

        javax.swing.GroupLayout tbs_time_pnlLayout = new javax.swing.GroupLayout(tbs_time_pnl);
        tbs_time_pnl.setLayout(tbs_time_pnlLayout);
        tbs_time_pnlLayout.setHorizontalGroup(
            tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tablespace_lbl)
                        .addGap(258, 258, 258)
                        .addComponent(time_lbl))
                    .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                                .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(note_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(addEvt_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delteEvt_btn)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbs_time_pnlLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(date_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(createStrategy_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        tbs_time_pnlLayout.setVerticalGroup(
            tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time_lbl)
                    .addComponent(tablespace_lbl))
                .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(note_lbl))
                    .addGroup(tbs_time_pnlLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tbs_time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addEvt_btn)
                            .addComponent(delteEvt_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createStrategy_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        database_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        database_lbl.setForeground(new java.awt.Color(0, 0, 0));
        database_lbl.setText("Database");

        databases_cmb.setModel(databases());
        databases_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databases_cmbActionPerformed(evt);
            }
        });

        control_chk.setText("Control Files");

        archive_chk.setText("ArchiveLogs");

        include_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        include_lbl.setForeground(new java.awt.Color(0, 0, 0));
        include_lbl.setText("Include");

        javax.swing.GroupLayout db_include_pnlLayout = new javax.swing.GroupLayout(db_include_pnl);
        db_include_pnl.setLayout(db_include_pnlLayout);
        db_include_pnlLayout.setHorizontalGroup(
            db_include_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(db_include_pnlLayout.createSequentialGroup()
                .addGroup(db_include_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(db_include_pnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(database_lbl)
                        .addGap(282, 282, 282)
                        .addComponent(include_lbl))
                    .addGroup(db_include_pnlLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(databases_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(archive_chk)
                        .addGap(18, 18, 18)
                        .addComponent(control_chk)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        db_include_pnlLayout.setVerticalGroup(
            db_include_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(db_include_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(db_include_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(database_lbl)
                    .addComponent(include_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(db_include_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databases_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archive_chk)
                    .addComponent(control_chk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout strategy_pnlLayout = new javax.swing.GroupLayout(strategy_pnl);
        strategy_pnl.setLayout(strategy_pnlLayout);
        strategy_pnlLayout.setHorizontalGroup(
            strategy_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(name_mode_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(db_include_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(strategy_pnlLayout.createSequentialGroup()
                .addComponent(header_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(tbs_time_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        strategy_pnlLayout.setVerticalGroup(
            strategy_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(strategy_pnlLayout.createSequentialGroup()
                .addComponent(header_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name_mode_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(db_include_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbs_time_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create new Strategy", strategy_pnl);

        viewer_pnl.setLayout(new java.awt.BorderLayout());

        banner_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/banner.png"))); // NOI18N
        banner_lbl.setBorder(null);

        javax.swing.GroupLayout header2_pnlLayout = new javax.swing.GroupLayout(header2_pnl);
        header2_pnl.setLayout(header2_pnlLayout);
        header2_pnlLayout.setHorizontalGroup(
            header2_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        header2_pnlLayout.setVerticalGroup(
            header2_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        filter_btn.setText("Filter");
        filter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Disable strategy");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filter_pnlLayout = new javax.swing.GroupLayout(filter_pnl);
        filter_pnl.setLayout(filter_pnlLayout);
        filter_pnlLayout.setHorizontalGroup(
            filter_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filter_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(delete_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(filter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter_btn))
        );
        filter_pnlLayout.setVerticalGroup(
            filter_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filter_pnlLayout.createSequentialGroup()
                .addGroup(filter_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filter_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete_btn))
                    .addGroup(filter_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filter_btn)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout table_pnlLayout = new javax.swing.GroupLayout(table_pnl);
        table_pnl.setLayout(table_pnlLayout);
        table_pnlLayout.setHorizontalGroup(
            table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_pnlLayout.createSequentialGroup()
                .addGroup(table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        table_pnlLayout.setVerticalGroup(
            table_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_pnlLayout.createSequentialGroup()
                .addComponent(header2_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewer_pnl.add(table_pnl, java.awt.BorderLayout.PAGE_START);

        table.setModel(PACKAGES.Manager.tm);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archivo(evt);
            }
        });
        tables_scroll_pnl.setViewportView(table);

        viewer_pnl.add(tables_scroll_pnl, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("View all Strategies", viewer_pnl);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        Help.setText("Help");

        time_drd.setText("Undertanding Date & Time");
        time_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_drdActionPerformed(evt);
            }
        });
        Help.add(time_drd);

        licenses_drd.setText("License");
        licenses_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenses_drdActionPerformed(evt);
            }
        });
        Help.add(licenses_drd);

        third_party_drd.setText("Third Party Libraries");
        third_party_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                third_party_drdActionPerformed(evt);
            }
        });
        Help.add(third_party_drd);

        about_drd.setText("About the Authors");
        about_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_drdActionPerformed(evt);
            }
        });
        Help.add(about_drd);

        fork_us_drd.setText("Get the Source Code");
        fork_us_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fork_us_drdActionPerformed(evt);
            }
        });
        Help.add(fork_us_drd);

        jMenuBar2.add(Help);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_btnActionPerformed
        if (!filter_txt.getText().isEmpty()) {
            Manager.filter(filter_txt.getText());
        } else {
            Manager.filter("\t");
        }
    }//GEN-LAST:event_filter_btnActionPerformed

    @SuppressWarnings("null")
    private void addEvt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEvt_btnActionPerformed
        NewTime nt = new NewTime();
        int i = 1;
        StringBuilder str = new StringBuilder();
        do {
            switch (i) {
                case 0:
                    str = null;
                    i = 100;
                    break;
                case 1:
                    i = JOptionPane.showOptionDialog(null, nt, "New Time",
                            JOptionPane.DEFAULT_OPTION, -1, null,
                            new String[]{"Abort", "Add another",
                                "Save & Exit"},
                            "default");
                    nt.getTime(str);
                    nt = new NewTime();
                    str.append("|");
                    break;
                case 2:
                    date_txt.setText(str.toString().substring(0, str.length() - 1));
                    i = 100;
                    break;
                default:
                    break;
            }
        } while (i != 100);
    }//GEN-LAST:event_addEvt_btnActionPerformed

    private void delteEvt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delteEvt_btnActionPerformed
        date_txt.setText("");
    }//GEN-LAST:event_delteEvt_btnActionPerformed

    private void databases_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databases_cmbActionPerformed
        tbs();
    }//GEN-LAST:event_databases_cmbActionPerformed

    private boolean createStragedy() {
        String name = stragedy_txt.getText();
        if (Manager.readFiles(name).isEmpty()) {//Not exist previously (use name above)
            //Global between types
            String db = (String) databases_cmb.getModel().getSelectedItem();
            String time = date_txt.getText();
            boolean logfiles = archive_chk.isSelected();
            //Create RmanFile
            for (Enumeration<AbstractButton> buttons = modes_group.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    switch (button.getText()) {
                        case "Whole BackUp":
                            RmanWhole(name, getNameFromDB(db), logfiles);
                            break;
                        case "Incremental BackUp":
                            List<String> a = tablespaces_lst.getSelectedValuesList();
                            if (control_chk.isSelected() || logfiles || !a.isEmpty()) {
                                Object[] aux = a.toArray();
                                RmanIncremental(getNameFromDB(db), name, getLevel(), logfiles, control_chk.isSelected(), Arrays.copyOf(aux, aux.length, String[].class));
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "You must at least select one tablespace or the control files or logfiles", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        case "Full BackUp":
                            List<String> a2 = tablespaces_lst.getSelectedValuesList();
                            if (control_chk.isSelected() || logfiles || !a2.isEmpty()) {
                                Object[] aux2 = a2.toArray();
                                RmanFull(name, getNameFromDB(db), Arrays.copyOf(aux2, aux2.length, String[].class), logfiles);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "You must at least select one tablespace or the control files or logfiles", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                    }
                }
            }
            //Create StrategyFile 
            ConstructorFiles.createStrategyFile(name, db, time, true);
            DB dbinfo = DBManager.getDbs().get(db);
            if (dbinfo != null && dbinfo.getIP() != null && dbinfo.getLinux_user() != null) {
                ExeConnection.sendFiles(name, dbinfo.getLinux_user(), dbinfo.getIP()); //envia ambas cosas
                return true;
            } else {
                System.err.println("ERROR SENDING");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "The name for your strategy is already taken,\n select another name and try again", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private int getLevel() {
        if (lvl_0_rnd.isSelected()) {
            return 0;
        }
        return 1;
    }

    private void limpiarCampos() {
        stragedy_txt.setText("");
        date_txt.setText("");
        archive_chk.setSelected(false);
        control_chk.setSelected(false);
        databases_cmb.setSelectedIndex(0);
        full_rnd.setSelected(true);
        tbs();
    }

    private void mode_change(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mode_change
        for (Enumeration<AbstractButton> buttons = modes_group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "Whole BackUp":
                        control_chk.setSelected(true);
                        control_chk.setEnabled(false);
                        note_lbl.setEnabled(false);
                        tablespace_lbl.setEnabled(false);
                        tablespaces_lst.setSelectionInterval(0, tbs.getSize() - 1);
                        tablespaces_lst.setEnabled(false);
                        level_lbl.setEnabled(false);
                        lvl_0_rnd.setEnabled(false);
                        lvl_1_rnd.setEnabled(false);
                        break;
                    case "Incremental BackUp":
                        control_chk.setEnabled(true);
                        note_lbl.setEnabled(true);
                        tablespace_lbl.setEnabled(true);
                        tablespaces_lst.setSelectedIndex(0);
                        tablespaces_lst.setEnabled(true);
                        level_lbl.setEnabled(true);
                        lvl_0_rnd.setEnabled(true);
                        lvl_1_rnd.setEnabled(true);
                        break;
                    case "Full BackUp":
                        control_chk.setEnabled(true);
                        note_lbl.setEnabled(true);
                        tablespace_lbl.setEnabled(true);
                        tablespaces_lst.setSelectedIndex(0);
                        tablespaces_lst.setEnabled(true);
                        level_lbl.setEnabled(false);
                        lvl_0_rnd.setEnabled(false);
                        lvl_1_rnd.setEnabled(false);
                        break;
                }
            }
        }
    }//GEN-LAST:event_mode_change

    private void createStrategy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStrategy_btnActionPerformed
        if (stragedy_txt.getText().equals("") || date_txt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You must digit a name for the strategy and set the time for execution", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (createStragedy()) {
                JOptionPane.showMessageDialog(null, "Strategy " + stragedy_txt.getText() + " Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_createStrategy_btnActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        Manager.filter("\t");
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (!(delete_txt.getText().equals("\t") || delete_txt.getText().isEmpty())) {
            List<String[]> aux2 = Manager.changeFile(delete_txt.getText());
            if (!aux2.isEmpty()) {
                String[] aux = aux2.get(0);
                ConstructorFiles.createStrategyFile(aux[0], aux[4], aux[1], false);
                DB dbinfo = DBManager.getDbs().get(aux[4]);
                if (dbinfo != null && dbinfo.getIP() != null && dbinfo.getLinux_user() != null) {
                    if (ExeConnection.sendFiles(aux[0], dbinfo.getLinux_user(), dbinfo.getIP())) {
                        JOptionPane.showMessageDialog(null, "Success disabling the strategy", "Success", JOptionPane.INFORMATION_MESSAGE);
                        Manager.filter("\t");
                    } //send both
                } else {
                    System.err.println("ERROR SENDING");
                    ConstructorFiles.createStrategyFile(aux[0], aux[4], aux[1], true);
                    JOptionPane.showMessageDialog(null, "Error disabling the strategy, the destination is not available", "Error sending", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is not any strategy called " + delete_txt.getText() + " and marked as active", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must provide a valid name", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void time_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_drdActionPerformed
        JOptionPane.showMessageDialog(null, new javax.swing.ImageIcon(getClass().getResource("/IMG/cron.gif")), "Time Syntax", -1);
    }//GEN-LAST:event_time_drdActionPerformed

    private void licenses_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenses_drdActionPerformed
        JOptionPane.showMessageDialog(null, "This program is free software: you can redistribute it and/or modify\n"
                + "    it under the terms of the GNU General Public License as published by\n"
                + "    the Free Software Foundation, either version 3 of the License, or\n"
                + "    (at your option) any later version.\n"
                + "\n"
                + "    This program is distributed in the hope that it will be useful,\n"
                + "    but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
                + "    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"
                + "    GNU General Public License for more details.\n"
                + "\n"
                + "    You should have received a copy of the GNU General Public License\n"
                + "    along with this program.  If not, see <http://www.gnu.org/licenses/>.", "License GPLv3", -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/gpl3.png")));
    }//GEN-LAST:event_licenses_drdActionPerformed

    private void third_party_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_third_party_drdActionPerformed
        JOptionPane.showMessageDialog(null, "For the Scheduler is in Use on the Executor Side\n"
                + "CRON4J by Sauron Software\n"
                + "cron4j is Free Software and it is licensed under LGPL\n", "Third Party Software", -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/lgpl3.png")));
    }//GEN-LAST:event_third_party_drdActionPerformed

    private void about_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_drdActionPerformed
        JOptionPane.showMessageDialog(null, "This software was developed by Students\n"
                + "from National University of Costa Rica:  \"The truth makes us free\"\n\n"
                + "Javier Porras Valenzuela\n"
                + "Luis Carlos Segura Molina\n"
                + "Luis Enrique Ramírez Vargas\n"
                + "\nThe software was developed for Datbase Administration class\n"
                + "imparted by Msc. Johnny Villalobos Murillo", "About Students", -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/una.png")));
    }//GEN-LAST:event_about_drdActionPerformed

    private void fork_us_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fork_us_drdActionPerformed
        if (JOptionPane.showOptionDialog(null, "All our Source Code is available \n in Github Servers"
                + "just fork us at \n https://github.com/lerv22/BackUpManagerOracle\n"
                + "\nDo you want to go to the site?", "Fork Us",
                JOptionPane.DEFAULT_OPTION, -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/github.png")),
                new String[]{"No", "Yes"},
                "default") == 1) {
            try {
                Manager.openWebpage(new URL("https://github.com/lerv22/BackUpManagerOracle"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_fork_us_drdActionPerformed

    private void archivo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivo
        if (evt.getClickCount() == 2) {
            javax.swing.JTable target = (javax.swing.JTable) evt.getSource();
            int row = target.getSelectedRow();
            String rman = (String) table.getModel().getValueAt(row, 2);
            JOptionPane.showMessageDialog(null,
                    Manager.contentFile(rman),
                    "Log " + rman, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_archivo

    public javax.swing.ComboBoxModel databases() {
        java.util.ArrayList<String> vect = (ArrayList<String>) DBManager.getDbs().values().stream().map((x) -> x.getLink_name()).collect(Collectors.toList());
        return new javax.swing.DefaultComboBoxModel(vect.toArray());
    }

    private boolean tbs() {
        if (!tbs.isEmpty()) {
            tbs.clear();
        }
        String ss = (String) databases_cmb.getModel().getSelectedItem();
        if (ss != null) {
            DBManager.getDbs().get(ss).getTablespaces().stream().forEach((str) -> {
                tbs.addElement(str);
            });
            return true;
        } else {
            UIManager.put("OptionPane.okButtonText", "Exit program");
            JOptionPane.showMessageDialog(null, "It seems that the main database is off or not available, so you can not make changes,\n start your database and listener and try to launch the application again", "Blocked", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private final javax.swing.DefaultListModel tbs;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem about_drd;
    private javax.swing.JButton addEvt_btn;
    private javax.swing.JCheckBox archive_chk;
    private javax.swing.JLabel banner_lbl;
    private javax.swing.JCheckBox control_chk;
    private javax.swing.JButton createStrategy_btn;
    private javax.swing.JLabel database_lbl;
    private javax.swing.JComboBox databases_cmb;
    private javax.swing.JTextField date_txt;
    private javax.swing.JPanel db_include_pnl;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField delete_txt;
    private javax.swing.JButton delteEvt_btn;
    private javax.swing.JButton filter_btn;
    private javax.swing.JPanel filter_pnl;
    private javax.swing.JTextField filter_txt;
    private javax.swing.JMenuItem fork_us_drd;
    private javax.swing.JRadioButton full_rnd;
    private javax.swing.JPanel header2_pnl;
    private javax.swing.JPanel header_pnl;
    private javax.swing.ButtonGroup incLevel_group;
    private javax.swing.JLabel include_lbl;
    private javax.swing.JRadioButton incremetnal_rnd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel level_lbl;
    private javax.swing.JMenuItem licenses_drd;
    private javax.swing.JRadioButton lvl_0_rnd;
    private javax.swing.JRadioButton lvl_1_rnd;
    private javax.swing.ButtonGroup modes_group;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JPanel name_mode_pnl;
    private javax.swing.JLabel note_lbl;
    private javax.swing.JTextField stragedy_txt;
    private javax.swing.JPanel strategy_pnl;
    private javax.swing.JTable table;
    private javax.swing.JPanel table_pnl;
    private javax.swing.JScrollPane tables_scroll_pnl;
    private javax.swing.JLabel tablespace_lbl;
    private javax.swing.JList tablespaces_lst;
    private javax.swing.JPanel tbs_time_pnl;
    private javax.swing.JMenuItem third_party_drd;
    private javax.swing.JMenuItem time_drd;
    private javax.swing.JLabel time_lbl;
    private javax.swing.JRadioButton total_rnd;
    private javax.swing.JLabel type_lbl;
    private javax.swing.JPanel viewer_pnl;
    // End of variables declaration//GEN-END:variables
}
