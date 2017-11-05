package wxlter97;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import wxlter97.libfinancieros.TipoCuenta;

@Named(value = "mbTipoCuentas")
@ViewScoped
public class MbTipoCuentas implements Serializable {

    @EJB
    private TipoCuentaFacadeLocal tcfl;
    private TipoCuenta newTipoCuenta = new TipoCuenta();
    private TipoCuenta selectedTipoCuenta = new TipoCuenta();
    private List<TipoCuenta> lista;
    private List<TipoCuenta> lista2;
    private boolean nivel1 = false;
    private boolean nivel2 = false;
    private boolean nivel3 = false;
    
    @PostConstruct
    public void init() {
        this.setSelectedTipoCuenta(new TipoCuenta());
        this.setNewTipoCuenta(new TipoCuenta());
        lista = tcfl.findAll();
    }

    public List<TipoCuenta> cargarTabla() {
        return getTcfl().findAll();
    }

    
    public TipoCuenta getNewTipoCuenta() {
        return newTipoCuenta;
    }

    public void setNewTipoCuenta(TipoCuenta newCuenta) {
        this.newTipoCuenta = newCuenta;
    }

    public void crearCuenta() {
       tcfl.create(newTipoCuenta);
       this.setNewTipoCuenta(new TipoCuenta());
    }

    public TipoCuenta getSelectedTipoCuenta() {
        return selectedTipoCuenta;
    }

    public void setSelectedTipoCuenta(TipoCuenta selectedCuenta) {
        this.selectedTipoCuenta = selectedCuenta;

    }

    public void changeSelected(SelectEvent j) {
        this.setNewTipoCuenta((TipoCuenta) j.getObject());
        this.nivel1=true;
        this.nivel2=true;
        this.nivel3=true;
    }
    
    public void nuevo(){
        this.newTipoCuenta = new TipoCuenta();
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

    public boolean isNivel3() {
        return nivel3;
    }

    public void setNivel3(boolean nivel3) {
        this.nivel3 = nivel3;
    }

}
