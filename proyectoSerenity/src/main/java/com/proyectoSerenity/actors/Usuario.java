package com.proyectoSerenity.actors;

public class Usuario {
    private Login login;
    private Compra compra;

    public Login getLogin(){
        return login;
    }
    public void setLogin(){
        this.login = login;
    }

    public Compra getCompra(){return compra;}
    public void setCompra(){
        this.compra = compra;
    }

    public static class Login {
        private String correo;
        private String contrasenia;
        private String articulo1, articulo2, articulo3, articulo4, articulo5, articulo6;

        public String getCorreo(){
            return correo;
        }

        public void setCorreo(String correo){
            this.correo = correo;
        }
        public String getContrasenia(){
            return contrasenia;
        }

        public void setContrasenia(String contrasenia){
            this.contrasenia = contrasenia;
        }


    }

    public static class Compra {
        private String articulo1, articulo2, articulo3, articulo4, articulo5, articulo6;

        public String getArticulo1(){
            return articulo1;
        }
        public void setArticulo1(String articulo1){
            this.articulo1 = articulo1;
        }

        public String getArticulo2(){
            return articulo2;
        }
        public void setArticulo2(String articulo2){
            this.articulo2 = articulo2;
        }

        public String getArticulo3(){
            return articulo3;
        }
        public void setArticulo3(String articulo3){
            this.articulo3 = articulo3;
        }

        public String getArticulo4(){
            return articulo4;
        }
        public void setArticulo4(String articulo4){
            this.articulo4 = articulo4;
        }

        public String getArticulo5(){
            return articulo5;
        }
        public void setArticulo5(String articulo5){
            this.articulo5 = articulo5;
        }

        public String getArticulo6(){
            return articulo6;
        }
        public void setArticulo6(String articulo6){
            this.articulo6 = articulo6;
        }
    }

}