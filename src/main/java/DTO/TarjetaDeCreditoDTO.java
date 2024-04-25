package DTO;

public class TarjetaDeCreditoDTO {
    private Long id;
    private String numero;
    private Double cupo;
    private Double saldo;

    public TarjetaDeCreditoDTO(Long id, String numero, Double cupo, Double saldo) {
        this.id = id;
        this.numero = numero;
        this.cupo = cupo;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getCupo() {
        return cupo;
    }

    public void setCupo(Double cupo) {
        this.cupo = cupo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
