package administraciondeempleados;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Empresa {

    //atributos
    private String nombre;
    private String leyenda;
    private int fundacionYear = 0;
    private String rubro;
    
    //relaciones
    private List<Departamento> departamentoList;
    private List<Rol> rolList;
    private List<Horario> horarioList;
    private Calendar horaEntrada;
    private Gerente gerente;

    public Empresa(){
        horarioList = new LinkedList<>();
        rolList = new LinkedList();
        departamentoList = new LinkedList<>();
        this.horaEntrada = Calendar.getInstance();//quitar mas tarde
    }
    
    public Empresa(String empresa, int fundacionYear, String rubro) {
        this();
        this.nombre = empresa;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
        this.horaEntrada = Calendar.getInstance();
    }
    
    public Empresa(String nombre, int fundacionYear, String fundador, String rubro){
        this(nombre, fundacionYear, rubro);
        this.leyenda = fundador;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String empresa) {
        this.nombre = empresa;
    }
    
    public int getFundacionYear() {
        return fundacionYear;
    }

    public void setFundacionYear(int fundacionYear) {
        if(this.fundacionYear == 0){
            this.fundacionYear = fundacionYear;
        }
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }
    
    public Calendar getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int hora, int minuto) {
        horaEntrada.set(Calendar.HOUR_OF_DAY, hora);
        horaEntrada.set(Calendar.MINUTE, minuto);
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", fundacionYear=" + fundacionYear + ", rubro=" + rubro + ", leyenda=" + leyenda + '}';
    }
    
}