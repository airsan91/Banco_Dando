package modelo;

public class Usuario {
    private Long id;
    private String nombre;
    private String username;
    private String password;
    private Double ingresosMensuales;
    private Double gastos;
    private Double deudas;

    public Usuario(Long id, String nombre, String username, String password, Double ingresosMensuales, Double gastos, Double deudas) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.ingresosMensuales = ingresosMensuales;
        this.gastos = gastos;
        this.deudas = deudas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(Double ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public Double getDeudas() {
        return deudas;
    }

    public void setDeudas(Double deudas) {
        this.deudas = deudas;
    }
}
