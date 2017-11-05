package wxlter97;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import wxlter97.libfinancieros.Cuentas;
import wxlter97.libfinancieros.TipoCuenta;

@Named(value = "mbCuentas")
@ViewScoped
public class MbCuentas implements Serializable {

    @EJB
    private CuentasFacadeLocal cfl;
    @EJB
    private TipoCuentaFacadeLocal tcfl;
    private Cuentas newCuenta = new Cuentas();
    private Cuentas selectedCuenta = new Cuentas();
    private List<TipoCuenta> lista;
    private TipoCuenta selectedTipoCuentaDependiente = new TipoCuenta();
    private TipoCuenta selectedTipoCuentaDependiente2 = new TipoCuenta();
    private List<TipoCuenta> lista2;
    private boolean nivel1 = false;
    private boolean nivel2 = false;
    private boolean nivel3 = false;
    
    @PostConstruct
    public void init() {
        this.setSelectedCuenta(new Cuentas());
        this.setNewCuenta(new Cuentas());
        getNewCuenta().setTipoCuenta(new TipoCuenta());

    }

    public List<Cuentas> cargarTabla() {
        return getCfl().findAll();
    }

    public CuentasFacadeLocal getCfl() {
        return cfl;
    }

    public void setCfl(CuentasFacadeLocal cfl) {
        this.cfl = cfl;
    }

    public Cuentas getNewCuenta() {
        return newCuenta;
    }

    public void setNewCuenta(Cuentas newCuenta) {
        this.newCuenta = newCuenta;
    }

    public void changeMierda() {
        this.setNivel1(true);
        setLista(getNewCuenta().getTipoCuenta().getTipoCuentaList());
        if (this.getNewCuenta() != null) {
            System.out.println(getNewCuenta().getNombreCuenta());
            System.out.println(getNewCuenta().getTipoCuenta().getId());
            System.out.println("Cambiado: " + this.getNewCuenta().getTipoCuenta().getNombreTipoCuenta());
            for (TipoCuenta t : getLista()) {
                System.out.println(t.getNombreTipoCuenta());
            }
        } else {
            System.out.println("CACA");

        }

    }

    public void changeMierda2() {
        this.setNivel2(true);
        setLista2(getNewCuenta().getTipoCuenta().getTipoCuentaList());
        if (this.getNewCuenta() != null) {
            System.out.println(getNewCuenta().getNombreCuenta());
            System.out.println(getNewCuenta().getTipoCuenta().getId());
            System.out.println("Cambiado: " + this.getNewCuenta().getTipoCuenta().getNombreTipoCuenta());
            for (TipoCuenta t : getLista()) {
                System.out.println(t.getNombreTipoCuenta());
            }
        } else {
            System.out.println("CACA");

        }
    }
    
    public void changeMierda3() {
        this.setNivel3(true);
    }

    public void crearCuenta() {
       cfl.create(newCuenta);
       this.setNewCuenta(new Cuentas());
    }

    public Cuentas getSelectedCuenta() {
        return selectedCuenta;
    }

    public void setSelectedCuenta(Cuentas selectedCuenta) {
        this.selectedCuenta = selectedCuenta;

    }

    public void changeSelected(SelectEvent j) {
        this.setNewCuenta((Cuentas) j.getObject());
        this.nivel1=true;
        this.nivel2=true;
        this.nivel3=true;
    }
    
    public void nuevo(){
        this.newCuenta = new Cuentas();
    }
    
    public void eliminar(){
     //   this.getCfl().remove(newCuenta);
    }

    public TipoCuentaFacadeLocal getTcfl() {
        return tcfl;
    }

    public void setTcfl(TipoCuentaFacadeLocal tcfl) {
        this.tcfl = tcfl;
    }

    public List<TipoCuenta> getLista() {
        return lista;
    }

    public void setLista(List<TipoCuenta> lista) {
        this.lista = lista;
    }

    public TipoCuenta getSelectedTipoCuentaDependiente() {
        return selectedTipoCuentaDependiente;
    }

    public void setSelectedTipoCuentaDependiente(TipoCuenta selectedTipoCuentaDependiente) {
        this.selectedTipoCuentaDependiente = selectedTipoCuentaDependiente;
    }

    public TipoCuenta getSelectedTipoCuentaDependiente2() {
        return selectedTipoCuentaDependiente2;
    }

    public void setSelectedTipoCuentaDependiente2(TipoCuenta selectedTipoCuentaDependiente2) {
        this.selectedTipoCuentaDependiente2 = selectedTipoCuentaDependiente2;
    }

    public List<TipoCuenta> getLista2() {
        return lista2;
    }

    public void setLista2(List<TipoCuenta> lista2) {
        this.lista2 = lista2;
    }

    public boolean isNivel1() {
        return nivel1;
    }

    public void setNivel1(boolean nivel1) {
        this.nivel1 = nivel1;
    }

    public boolean isNivel2() {
        return nivel2;
    }

    public void setNivel2(boolean nivel2) {
        this.nivel2 = nivel2;
    }

    /**
     * @return the nivel3
     */
    public boolean isNivel3() {
        return nivel3;
    }

    /**
     * @param nivel3 the nivel3 to set
     */
    public void setNivel3(boolean nivel3) {
        this.nivel3 = nivel3;
    }

}
