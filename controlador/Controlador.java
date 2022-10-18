package controlador;

import modelo.Empleado;
import modelo.EmpresaAutomotriz;
import vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener
{
    //------------------
    //Atributos
    //------------------
    private VentanaPrincipal venPrin;
    private EmpresaAutomotriz empresa;

    //------------------
    //Metodos
    //------------------

    //Constructor
    public Controlador(VentanaPrincipal pVenPrin, EmpresaAutomotriz pEmpresa)
    {
        this.venPrin = pVenPrin;
        this.empresa = pEmpresa;
        this.venPrin.miPanelOperaciones.agregarOyentesBotones(this);
        this.venPrin.miPanelResultados.mostrarResultado("Se ha creado un objeto EmpresaAutomotriz...");
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comando = ae.getActionCommand();

        //Abrir ventana Agregar vendedor
        if(comando.equals("agregarVendedor"))
        {
            venPrin.crearDialogoAgregarVendedor();
            this.venPrin.miDialogoAgregarVendedor.agregarOyenteBoton(this);
        }

        //Agregar vendedor
        if(comando.equals("agregar"))
        {
            String nombre = venPrin.miDialogoAgregarVendedor.getNombreVendedor();
            empresa.agregarEmpleado(new Empleado(nombre));
            venPrin.miPanelEntradaDatos.setEmpleado(nombre);
            venPrin.miPanelResultados.mostrarResultado("Se ha agreado un nuevo empleado: " + nombre);
            venPrin.miDialogoAgregarVendedor.cerrarDialogoAgregarVendedor();
        }

        //Abrir ventana Vender un carro
        if(comando.equals("venderCarro"))
        {
            venPrin.crearDialogoVenderCarro();
            this.venPrin.miDialogoVenderCarro.agregarOyenteBoton(this);
        }

        //Vender carro
        if(comando.equals("vender"))
        {

        }

        //Calcular el sueldo de un vendedor
        if(comando.equals("calcularSueldo"))
        {

        }

        //Liquidar nomina total empresa
        if(comando.equals("liquidarNomina"))
        {

        }


        //Salir
        if(comando.equals("salir"))
        {
            System.exit(0);
        }  
    }
}
