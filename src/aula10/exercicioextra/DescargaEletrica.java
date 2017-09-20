package aula10.exercicioextra;

public class DescargaEletrica {

    String latitude;
    String longitude;
    String dataHora;
    String descricao;
    
    public DescargaEletrica(){
    
    }
    
    public DescargaEletrica(String latitude, String longitude, String dataHora, String descricao){
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitute() {
        return longitude;
    }

    public void setLongitute(String longitude) {
        this.longitude = longitude;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString(){
        return dataHora;
    }
}
