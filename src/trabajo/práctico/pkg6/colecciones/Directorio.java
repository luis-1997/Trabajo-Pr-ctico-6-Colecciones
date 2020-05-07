/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo.práctico.pkg6.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author LuisPc-Master
 */
public class Directorio {

    private TreeMap<Long, Cliente> dir = new TreeMap<>();

    public void agregarCliente(long telefono, Cliente cliente) {

        dir.putIfAbsent(telefono, cliente);//putIfAbsent controla que la clave no se repita//controla

        System.out.print(telefono + " ");
        System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " " + cliente.getCiudad() + " " + cliente.getDireccion() + "\n");

    }

    public Cliente buscarCliente(long telefono) {

        if (dir.containsKey(telefono) == true) {
            System.out.println("Cliente que busca se llama: " + dir.get(telefono).getNombre());
        } else {
            System.out.println("Cliente que esta buscando no se encuentra.");
        }

        return dir.get(telefono);

    }

    public Set<Long> buscarTelefono(String apellido) {
        HashSet<Long> telefonos = new HashSet<>();

        Set<Long> tels = dir.keySet();
        Iterator it = tels.iterator();
        while (it.hasNext()) {
            Long telefono = (Long) it.next();
            Cliente c = dir.get(telefono);

            if (c.getApellido().equals(apellido)) {
                telefonos.add(telefono);
            }

        }//fin

        System.out.println("El Numero telefonico de: " + apellido + " es: " + telefonos);
        return telefonos;

    }

    public List<Cliente> buscarClientes(String ciudad) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Set<Long> tels = dir.keySet();//clave telefonos 
        Iterator it = tels.iterator();
        while (it.hasNext()) {
            Long telefono = (Long) it.next();
            Cliente c = dir.get(telefono);

            if (c.getCiudad().equals(ciudad)) {
                clientes.add(c);
                System.out.println("Los Clientes de las ciudades es: " + c.getNombre());
            }

        }//fin

        return clientes;

    }

    public void borrarCliente(long telefono) {

        dir.remove(telefono);

        System.out.println("EL cliente fue removido o borrado.");

    }

}
