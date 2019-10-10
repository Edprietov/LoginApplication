/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DNIA-B-19
 */
public class TestRegistro {
    
    
    private static ValidarRegistro validarRegistro = new ValidarRegistro();
        
    
     private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
     private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta"; //
     private String DATOS_CORRECTOS = "Registro exitoso";
     private String USUARIO_REGISTRADO = "Usuario ya Registrado";
     private String CONTRASEÑAS_NSI = "Las contraseñas no coinciden";

     
  
    public TestRegistro() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        
         ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
         c.setNombre("maria");
         c.setPassword("12345");
         
         usuarios.add(a);
         usuarios.add(b);
         usuarios.add(c);
         
         sistema.setUsuarios(usuarios);
         
         for(Usuario u: sistema.getUsuarios()){
             System.out.println(u.getNombre());
             System.out.println(u.getPassword());
             System.out.println("----------");
         }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
       @Test
    public void testLongitudNombre(){
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        u.setPasswordv("123456");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_NOMBRE_INCORRECTA);
         
        
       
        u.setNombre("Claudia");
        u.setPassword("2323");
        u.setPasswordv("2323");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_NOMBRE_INCORRECTA);
    }
// TIENEN QUE SER LAS MISMAS CADENAS!!!!!!!!    

    @Test
    public void testLongitudContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("2322455");
        u.setPasswordv("2322455");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_PASSWORD_INCORRECTA);
         
        
       
        u.setNombre("Clau");
        u.setPassword("2322455");
        u.setPasswordv("2322");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_PASSWORD_INCORRECTA);
    }
    
        @Test
    public void testExistenciaUsuario(){
        Usuario u = new Usuario();
        u.setNombre("maria");
        u.setPassword("4357");
        u.setPasswordv("4357");
        assertEquals(validarRegistro.verificarRegistro(u), USUARIO_REGISTRADO);
         
        
       
        u.setNombre("pedro");
        u.setPassword("2356");
        u.setPasswordv("2345");
        assertEquals(validarRegistro.verificarRegistro(u), USUARIO_REGISTRADO);
    }
    
            @Test
    public void testCoincidenciaContraseña(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("1234");
        u.setPasswordv("3456");
        assertEquals(validarRegistro.verificarRegistro(u), CONTRASEÑAS_NSI);
         
        
       
        u.setNombre("Clau");
        u.setPassword("3456");
        u.setPasswordv("3465");
        assertEquals(validarRegistro.verificarRegistro(u), CONTRASEÑAS_NSI);
    }
    
              @Test
    public void testTodoCorrecto(){
        Usuario u = new Usuario();
        
        u.setNombre("Henry");
        u.setPassword("12345");
        u.setPasswordv("12345");
        assertEquals(validarRegistro.verificarRegistro(u), DATOS_CORRECTOS);
        
        u.setNombre("Clau");
        u.setPassword("3434");
        u.setPasswordv("3434");
        assertEquals(validarRegistro.verificarRegistro(u), DATOS_CORRECTOS);
        
        u.setNombre("Danny");
        u.setPassword("e452");
        u.setPasswordv("e452");
        assertEquals(DATOS_CORRECTOS,validarRegistro.verificarRegistro(u));
        
       
    }
    
}
