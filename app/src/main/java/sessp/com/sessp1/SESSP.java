package sessp.com.sessp1;

import java.io.Serializable;

public class SESSP implements Serializable {

    private String cnpj;
    private double base2014,pago2014,base2015,pago2015,base2016,pago2016,base2017,pago2017,valorUltimoConvenio,baseMensal,pagoUltimoConvenio,pagarUltimoConvenio,valorUltimoPagamento;
    private String conveniado,municipio,tipo,drs,regiaoAdm,programa,palavraChave,natureza,dataUltimoConvenio,dataUltimoPagamento;
    private int parcelasUltimoConvenio;


    public SESSP(String cnpj, String conveniado, String municipio, String tipo, String drs, String regiaoAdm, String programa, String palavraChave,
                 String natureza, double base2014, double pago2014, double base2015, double pago2015, double base2016,
                 double pago2016, double base2017, double pago2017, double valorUltimoConvenio, double baseMensal,
                 double pagoUltimoConvenio, double pagarUltimoConvenio, String dataUltimoConvenio, String dataUltimoPagamento, double valorUltimoPagamento,
                 int parcelasUltimoConvenio) {

        super();
        this.cnpj = cnpj;
        this.base2014 = base2014;
        this.pago2014 = pago2014;
        this.base2015 = base2015;
        this.pago2015 = pago2015;
        this.base2016 = base2016;
        this.pago2016 = pago2016;
        this.base2017 = base2017;
        this.pago2017 = pago2017;
        this.valorUltimoConvenio = valorUltimoConvenio;
        this.baseMensal = baseMensal;
        this.pagoUltimoConvenio = pagoUltimoConvenio;
        this.pagarUltimoConvenio = pagarUltimoConvenio;
        this.valorUltimoPagamento = valorUltimoPagamento;
        this.conveniado = conveniado;
        this.municipio = municipio;
        this.tipo = tipo;
        this.drs = drs;
        this.regiaoAdm = regiaoAdm;
        this.programa = programa;
        this.palavraChave = palavraChave;
        this.natureza = natureza;
        this.dataUltimoConvenio = dataUltimoConvenio;
        this.dataUltimoPagamento = dataUltimoPagamento;
        this.parcelasUltimoConvenio = parcelasUltimoConvenio;
    }

    public SESSP(){


    }

    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public double getBase2014() {
        return base2014;
    }


    public void setBase2014(double base2014) {
        this.base2014 = base2014;
    }


    public double getPago2014() {
        return pago2014;
    }


    public void setPago2014(double pago2014) {
        this.pago2014 = pago2014;
    }


    public double getBase2015() {
        return base2015;
    }


    public void setBase2015(double base2015) {
        this.base2015 = base2015;
    }


    public double getPago2015() {
        return pago2015;
    }


    public void setPago2015(double pago2015) {
        this.pago2015 = pago2015;
    }


    public double getBase2016() {
        return base2016;
    }


    public void setBase2016(double base2016) {
        this.base2016 = base2016;
    }


    public double getPago2016() {
        return pago2016;
    }


    public void setPago2016(double pago2016) {
        this.pago2016 = pago2016;
    }


    public double getBase2017() {
        return base2017;
    }


    public void setBase2017(double base2017) {
        this.base2017 = base2017;
    }


    public double getPago2017() {
        return pago2017;
    }


    public void setPago2017(double pago2017) {
        this.pago2017 = pago2017;
    }


    public double getValorUltimoConvenio() {
        return valorUltimoConvenio;
    }


    public void setValorUltimoConvenio(double valorUltimoConvenio) {
        this.valorUltimoConvenio = valorUltimoConvenio;
    }


    public double getBaseMensal() {
        return baseMensal;
    }


    public void setBaseMensal(double baseMensal) {
        this.baseMensal = baseMensal;
    }


    public double getPagoUltimoConvenio() {
        return pagoUltimoConvenio;
    }


    public void setPagoUltimoConvenio(double pagoUltimoConvenio) {
        this.pagoUltimoConvenio = pagoUltimoConvenio;
    }


    public double getPagarUltimoConvenio() {
        return pagarUltimoConvenio;
    }


    public void setPagarUltimoConvenio(double pagarUltimoConvenio) {
        this.pagarUltimoConvenio = pagarUltimoConvenio;
    }


    public double getValorUltimoPagamento() {
        return valorUltimoPagamento;
    }


    public void setValorUltimoPagamento(double valorUltimoPagamento) {
        this.valorUltimoPagamento = valorUltimoPagamento;
    }


    public String getConveniado() {
        return conveniado;
    }


    public void setConveniado(String conveniado) {
        this.conveniado = conveniado;
    }


    public String getMunicipio() {
        return municipio;
    }


    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getDrs() {
        return drs;
    }


    public void setDrs(String drs) {
        this.drs = drs;
    }


    public String getRegiaoAdm() {
        return regiaoAdm;
    }


    public void setRegiaoAdm(String regiaoAdm) {
        this.regiaoAdm = regiaoAdm;
    }


    public String getPrograma() {
        return programa;
    }


    public void setPrograma(String programa) {
        this.programa = programa;
    }


    public String getPalavraChave() {
        return palavraChave;
    }


    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }


    public String getNatureza() {
        return natureza;
    }


    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }


    public String getDataUltimoConvenio() {
        return dataUltimoConvenio;
    }


    public void setDataUltimoConvenio(String dataUltimoConvenio) {
        this.dataUltimoConvenio = dataUltimoConvenio;
    }


    public String getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }


    public void setDataUltimoPagamento(String dataUltimoPagamento) {
        this.dataUltimoPagamento = dataUltimoPagamento;
    }


    public int getParcelasUltimoConvenio() {
        return parcelasUltimoConvenio;
    }


    public void setParcelasUltimoConvenio(int parcelasUltimoConvenio) {
        this.parcelasUltimoConvenio = parcelasUltimoConvenio;
    }


}
