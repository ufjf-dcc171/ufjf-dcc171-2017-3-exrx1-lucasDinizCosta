package aula10.exercicioextra;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class DescargaListModel implements ListModel<DescargaEletrica> {

    private final List<DescargaEletrica> descargaEletrica;
    private final List<ListDataListener> dataListeners;                 ///Gerenciar a mudança nos dados - dispara eventos para controle

    public DescargaListModel(List<DescargaEletrica> descargaEletrica) {
        this.descargaEletrica = descargaEletrica;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return descargaEletrica.size();
    }

    @Override
    public DescargaEletrica getElementAt(int index) {
        return descargaEletrica.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
}
