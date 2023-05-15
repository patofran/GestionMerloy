public class DatosPagos {

    private int codigo_cliente;
    private String forma_pago;
    private String id_transaccion;        
    private String fecha_pago;
    private float total;
    
    
    public DatosPagos(int codigo_cliente, String forma_pago, String id_transaccion, String fecha_pago, float total) {
        this.codigo_cliente = codigo_cliente;
        this.forma_pago = forma_pago;
        this.id_transaccion = id_transaccion;
        this.fecha_pago = fecha_pago;
        this.total = total;
    }

    @Override
    public String toString() {
        return "DatosPagos{" + "codigo_cliente=" + codigo_cliente + ", forma_pago=" + forma_pago + ", id_transaccion=" + id_transaccion + ", fecha_pago=" + fecha_pago + ", total=" + total + '}';
    }
    
    
    
}

