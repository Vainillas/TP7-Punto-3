package ar.unrn.parcial.modelo;

import java.util.List;

public abstract class Observable {

        private List<Observer> observadores;
    
        public Observable(List<Observer> observadores) {
            this.observadores = observadores;
        }
    
        protected void notificar(String cantidad, String fecha, String monto, String correoDestino) {
            for (Observer o : observadores) {
                o.actualizar(cantidad,fecha,monto,correoDestino);
            }
        }
    
    }

