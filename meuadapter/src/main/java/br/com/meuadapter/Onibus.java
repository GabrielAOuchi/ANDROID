package br.com.meuadapter;

public class Onibus {
    private String marca;
    private String modelo;
    private String origemDestino;
    private String tipo;
    private String qntdAcentos;
    private String qntdAcentosOcupados;

    public Onibus(){

    }

    public Onibus(String marca, String modelo, String origemDestino, String tipo, String qntdAcentos, String qntdAcentosOcupados) {
        this.marca = marca;
        this.modelo = modelo;
        this.origemDestino = origemDestino;
        this.tipo = tipo;
        this.qntdAcentos = qntdAcentos;
        this.qntdAcentosOcupados = qntdAcentosOcupados;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOrigemDestino() {
        return origemDestino;
    }

    public void setOrigemDestino(String origemDestino) {
        this.origemDestino = origemDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQntdAcentos() {
        return qntdAcentos;
    }

    public void setQntdAcentos(String qntdAcentos) {
        this.qntdAcentos = qntdAcentos;
    }

    public String getQntdAcentosOcupados() {
        return qntdAcentosOcupados;
    }

    public void setQntdAcentosOcupados(String qntdAcentosOcupados) {
        this.qntdAcentosOcupados = qntdAcentosOcupados;
    }
}
