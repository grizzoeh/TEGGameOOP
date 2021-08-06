package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.NoHayMasObjetivosException;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ListaObjetivos;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoComun;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoParticular;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestListaObjetivos {
    Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);

    @Test
    public void test01AlCrearseSeInicializanLosOchoObjetivos(){
        ListaObjetivos listaobj = new ListaObjetivos(mapa, false);

        assertEquals(listaobj.cantidadDeObjetivos(), 8);
    }
    @Test
    public void test02AlPedirElObjetivoGeneralSeDevuelveAEste(){
        ListaObjetivos listaobj = new ListaObjetivos(mapa, true);
        ObjetivoComun objetivoBuscado = listaobj.asignarObjetivoComun();

        assertEquals(objetivoBuscado.mostrarObjetivo(), "Ocupar 30 países.");
    }

    @Test
    public void test03SiPidoUnObjetivoSeReduceLaCantidadCorrectamente(){
        ListaObjetivos listaobj = new ListaObjetivos(mapa,true);

        int cantidad = listaobj.cantidadDeObjetivos();
        ObjetivoParticular objetiv = listaobj.asignarObjetivoParticular();

        assertEquals(cantidad - 1 , listaobj.cantidadDeObjetivos());
    }
    @Test
    public void test04SiPidoMasQueTodosLosObjetivoSeLanzaExcepcion(){
        ListaObjetivos listaobj = new ListaObjetivos(mapa, true);

        int cantidad = listaobj.cantidadDeObjetivos();
        ObjetivoParticular objetiv = listaobj.asignarObjetivoParticular();
        objetiv = listaobj.asignarObjetivoParticular();
        objetiv = listaobj.asignarObjetivoParticular();
        objetiv = listaobj.asignarObjetivoParticular();
        objetiv = listaobj.asignarObjetivoParticular();
        objetiv = listaobj.asignarObjetivoParticular();
        objetiv = listaobj.asignarObjetivoParticular();


        assertThrows(NoHayMasObjetivosException.class,
                () -> {
                     listaobj.asignarObjetivoParticular();
                });
    }
    @Test
    public void test05ElPedirUnObjetivoEspecificoNosDevuelveElBuscado(){
        ListaObjetivos listaobj = new ListaObjetivos(mapa, false);

        ObjetivoParticular objetiv = listaobj.asignarObjetivoParticularEspecifico(1);

        assertEquals("Ocupar América del Sur, 7 países de Europa y 2 países de Oceanía.", objetiv.mostrarObjetivo());
    }
}
