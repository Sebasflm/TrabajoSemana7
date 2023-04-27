import java.util.Scanner;

public class Factura {
    public String nombre;
    public int cedula;
    public String opcion;
    public int producto;
    public int cantidadproducto;
    public int preciollantas;
    public int preciofrenos;
    public int precioembrague;
    public int preciofaro;
    public int precioradiador;
    public int subtotal;
    public double total;
    public String decision;
    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("                              Bienvenido");
        System.out.println("Seleccion (a,b,c) depenediendo de la accion que quiera realizar ");
        System.out.println("a) Facturar");
        System.out.println("b) Imprimir factura");
        System.out.println("c) Salir");
        this.opcion= sc.next();
    }
    public void accion(){
        if(opcion.equals("a")){
            facturar();
            calculofactura();
        }
        if(opcion.equals("b")){
            imprimirfactura();
        }
        if(opcion.equals("c")){
            System.exit(0);
        }
    }
    public void facturar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        this.nombre = sc.next();
        System.out.println("Ingrese su numero de cedula");
        this.cedula = sc.nextInt();
        do{
            System.out.println("El listado de productos disponibles es:");
            System.out.println("1. Llantas (Precio normal: $150) (Precio al por mayor, desde 6 unidades: $130)");
            System.out.println("2. Kit Pastillas de freno (Precio normal: $55) (Precio al por mayor, desde 12 unidades: $45");
            System.out.println("3. Kit de embrague (Precio normal: $180) (Precio al por mayor, desde 8 unidades:$165");
            System.out.println("4. Faro (Precio normal: $70) (Precio al por mayor, desde 10 unidades: $60)");
            System.out.println("5. Radiador (Precio normal: $120) (Precio al por mayor, desde 6 unidades: $105)\n\n");
            System.out.println("Para escoger el producto seleccione su correspondiente numero");
            this.producto = sc.nextInt();
            System.out.println("A continuacion ingrese la cantidad de unidades que desea del mismo");
            this.cantidadproducto = sc.nextInt();
            calculofactura();
            System.out.println("Desea facturar otro producto? si/no (Si decido no facturar mas, ya no podra hacerlo posteriormente");
            this.decision=sc.next();
        }while(decision.equals("si"));
        menu();
        accion();
    }
    public void calculofactura(){
        subtotal=0;
        switch(producto){
           case 1:
               if(cantidadproducto<6){
               preciollantas=cantidadproducto*150;
           }else{
                   preciollantas=cantidadproducto*130;
               }
               break;
           case 2:
               if(cantidadproducto<12){
                   preciofrenos=cantidadproducto*55;
               }else{
                   preciofrenos=cantidadproducto*45;
               }
               break;
           case 3:
               if(cantidadproducto<8){
                   precioembrague=cantidadproducto*180;
               }else{
                   precioembrague=cantidadproducto*165;
               }
               break;
           case 4:
               if(cantidadproducto<10){
                   preciofaro=cantidadproducto*70;
               }else{
                   preciofaro=cantidadproducto*60;
               }
               break;
           case 5:
               if(cantidadproducto<6){
                   precioradiador=cantidadproducto*120;
               }else{
                   precioradiador=cantidadproducto*105;
               }
               break;
       }
       subtotal=preciollantas+preciofrenos+precioembrague+preciofaro+precioradiador;
       if(subtotal<100){
           total=subtotal;
       }if(subtotal>=100 && subtotal<500 ){
            total=subtotal-subtotal*0.05;
       }if(subtotal>=500 && subtotal<1000 ){
            total=subtotal-subtotal*0.07;
       }if(subtotal>=100){
            total=subtotal-subtotal*0.1;
       }
    }
    public void imprimirfactura(){
        System.out.println("El nombre del cliente: "+nombre);
        System.out.println("EL numero de cedula es: "+cedula);
        System.out.println("El subtotal de la factura es: "+subtotal);
        System.out.println("El total de la factura es: "+total);
    }
}
