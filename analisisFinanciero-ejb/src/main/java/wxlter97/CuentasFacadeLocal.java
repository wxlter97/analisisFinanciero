/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxlter97;

import java.util.List;
import javax.ejb.Local;
import wxlter97.libfinancieros.Cuentas;

/**
 *
 * @author wxlter97
 */
@Local
public interface CuentasFacadeLocal {

    void create(Cuentas cuentas);

    void edit(Cuentas cuentas);

    void remove(Cuentas cuentas);

    Cuentas find(Object id);

    List<Cuentas> findAll();

    List<Cuentas> findRange(int[] range);

    int count();
    
}
