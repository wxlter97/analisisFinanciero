/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxlter97;

import java.util.List;
import javax.ejb.Local;
import wxlter97.libfinancieros.TipoCuenta;

/**
 *
 * @author wxlter97
 */
@Local
public interface TipoCuentaFacadeLocal {

    void create(TipoCuenta tipoCuenta);

    void edit(TipoCuenta tipoCuenta);

    void remove(TipoCuenta tipoCuenta);

    TipoCuenta find(Object id);

    List<TipoCuenta> findAll();

    List<TipoCuenta> findRange(int[] range);

    int count();
    
    List<TipoCuenta> findSinDependencias();
    
    List<TipoCuenta> findDependencias(Object filter);

    
}
