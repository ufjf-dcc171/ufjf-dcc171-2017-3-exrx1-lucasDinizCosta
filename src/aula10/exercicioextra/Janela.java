package aula10.exercicioextra;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Janela extends JFrame{
    private List<DescargaEletrica> descargaEletricas = new ArrayList<DescargaEletrica>();
    private JList<DescargaEletrica> lstDescargas= new JList<DescargaEletrica>(new DefaultListModel<>());
    private JLabel escritoLatitude = new JLabel("Latitude");
    private JLabel escritoLongitude = new JLabel("Longitude");
    private JLabel escritoDataHora = new JLabel("Data - hora");
    private JLabel escritoDescricao = new JLabel("Descricao");
    private JTextField caixaLatitude = new JTextField(30);
    private JTextField caixaLongitude = new JTextField(30);
    private JTextField caixaDataHora = new JTextField(30);
    private JTextField caixaDescricao = new JTextField(30);
    private JButton adicionarDescarga = new JButton("+");
    private JButton removerDescarga = new JButton("x");
    private JScrollPane fundoLista = new JScrollPane();

    public Janela() throws HeadlessException {
        super("Descarga elétricas");
        setLayout(null);
        setResizable(false);
        lstDescargas.setModel(new DescargaListModel(descargaEletricas));
        lstDescargas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstDescargas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                DescargaEletrica selecionada = lstDescargas.getSelectedValue();
                if(selecionada!=null){
                    caixaLatitude.setText(selecionada.getLatitude());
                    caixaLongitude.setText(selecionada.getLongitute());
                    caixaDataHora.setText(selecionada.getDataHora());
                    caixaDescricao.setText(selecionada.getDescricao());
                }
                else{
                    caixaLatitude.setText("");
                    caixaLongitude.setText("");
                    caixaDataHora.setText("");
                    caixaDescricao.setText("");
                }
            }
        });
        adicionarElementos();
        adicionarDescarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstDescargas.isSelectionEmpty()){                ///Não tem nenhuma descarga selecionada
                    if(!caixaLatitude.getText().isEmpty()&&!caixaLongitude.getText().isEmpty()&&!caixaDataHora.getText().isEmpty()&&!caixaDescricao.getText().isEmpty()){
                        DescargaEletrica descarga = new DescargaEletrica(caixaLatitude.getText(),caixaLongitude.getText(),caixaDataHora.getText(),caixaDescricao.getText());
                        descargaEletricas.add(descarga);
                        lstDescargas.updateUI();
                    }
                }
                else{
                    if(!caixaLatitude.getText().isEmpty()&&!caixaLongitude.getText().isEmpty()&&!caixaDataHora.getText().isEmpty()&&!caixaDescricao.getText().isEmpty()){
                        DescargaEletrica selecionada = lstDescargas.getSelectedValue();
                        selecionada.setLatitude(caixaLatitude.getText());
                        selecionada.setLongitute(caixaLongitude.getText());
                        selecionada.setDataHora(caixaDataHora.getText());
                        selecionada.setDescricao(caixaDescricao.getText());
                        JOptionPane.showMessageDialog(null, "Descarga editada com sucesso");
                        
                    }
                    
                
                }
                lstDescargas.updateUI();
                lstDescargas.clearSelection();
                
            }
        });
        removerDescarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstDescargas.isSelectionEmpty()){
                    return;
                }
                descargaEletricas.remove(lstDescargas.getSelectedValue());
                lstDescargas.clearSelection();
                lstDescargas.updateUI();
            }
        });
    };
    
    public void adicionarElementos(){
        fundoLista = new JScrollPane(lstDescargas);
        fundoLista.setBounds(0,0,100,200);
        add(fundoLista);
        escritoLatitude.setBounds(150,25,100,25);
        add(escritoLatitude);
        caixaLatitude.setBounds(235,25,250,25);
        add(caixaLatitude);
        escritoLongitude.setBounds(150,60,100,25);
        add(escritoLongitude);
        caixaLongitude.setBounds(235,60,250,25);
        add(caixaLongitude);
        escritoDataHora.setBounds(150,95,100,25);
        add(escritoDataHora);
        caixaDataHora.setBounds(235,95,250,25);
        add(caixaDataHora);
        escritoDescricao.setBounds(150,130,100,25);
        add(escritoDescricao);
        caixaDescricao.setBounds(235,130,250,25);
        add(caixaDescricao);
        adicionarDescarga.setBounds(0,200,50,25);
        add(adicionarDescarga);
        removerDescarga.setBounds(50,200,50,25);
        add(removerDescarga);
    }

}
